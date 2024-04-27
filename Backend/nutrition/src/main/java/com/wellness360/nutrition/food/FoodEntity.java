package com.wellness360.nutrition.food;

import java.util.Objects;
import java.util.Set;
import java.util.UUID;

import com.wellness360.common.interfaces.CrudEntity;
import com.wellness360.common.tools.MacroNutrientsCalculator;
import com.wellness360.nutrition.category.CategoryEntity;
import com.wellness360.nutrition.food.dtos.FoodCreateEntitiesDTO;
import com.wellness360.nutrition.food.dtos.FoodUpdateEntitiesDTO;
import com.wellness360.nutrition.preference.PreferenceEntity;
import com.wellness360.nutrition.recipe.ingredients.RecipeIngredientEntity;
import com.wellness360.nutrition.restriction.RestrictionEntity;
import com.wellness360.nutrition.tag.TagEntity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "food")
@Getter
@Setter(value = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class FoodEntity implements CrudEntity<FoodUpdateEntitiesDTO>{

  // ATRIBUTES
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  
  @Column(name = "uuid", unique = true, nullable = false, length = 36)
  private String uuid;

  @Column(name = "name", unique = true, nullable = false, length = 50)
  protected String name;

  @Column(name = "description", columnDefinition = "TEXT")
  private String description;

  @Column(name = "calories", nullable = false)
  private Short calories;

  @Column(name = "carbs", nullable = false)
  private Float carbs;

  @Column(name = "proteins", nullable = false)
  private Float proteins;

  @Column(name = "fats", nullable = false)
  private Float fats;

  @Column(name = "saturated_fats", nullable = false)
  private Float saturated_fats;

  @Column(name = "sodium", nullable = false)
  private Float sodium;

  @Column(name = "dietary_fiber", nullable = false)
  private Float dietary_fiber;

  @Column(name = "serving_amount", nullable = false)
  private Short serving_amount;

  @Column(name = "image_url", nullable = false)
  private String image_url;

  // RELATIONSHIPS
  @ManyToOne
  @JoinColumn(name = "tag_id" )
  @NonNull
  private TagEntity tag;

  @ManyToOne
  @JoinColumn(name = "category_id")
  @NonNull
  private CategoryEntity category;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "food")
  private Set<RecipeIngredientEntity> recipes;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "food")
  private Set<PreferenceEntity> preferences;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "food")
  private Set<RestrictionEntity> restricions;

  public FoodEntity(FoodCreateEntitiesDTO dto) {
    this.name = dto.getName();
    this.description = dto.getDescription();
    this.image_url = dto.getImage_url();
    this.serving_amount = 100;
    this.carbs = equalizeMacro(dto.getCarbs(), Float.valueOf(dto.getServing_amount()));
    this.proteins = equalizeMacro(dto.getProteins(), Float.valueOf(dto.getServing_amount()));;
    this.fats = equalizeMacro(dto.getFats(), Float.valueOf(dto.getServing_amount()));;
    this.saturated_fats = equalizeMacro(dto.getSaturated_fats(), Float.valueOf(dto.getServing_amount()));;
    this.sodium = equalizeMacro(dto.getSodium(), Float.valueOf(dto.getServing_amount()));;
    this.dietary_fiber = equalizeMacro(dto.getDietary_fiber(), Float.valueOf(dto.getServing_amount()));;
    this.calories = MacroNutrientsCalculator.calculateCalories(this.carbs, this.proteins, this.fats);
    this.tag = dto.getTag();
    this.category = dto.getCategory();
  }

  private Float equalizeMacro(Float macro, Float current_amount) {
    return MacroNutrientsCalculator.equalizeToNewAmount(macro, current_amount, Float.valueOf(this.serving_amount));
  }

  @PrePersist
  private void initializeUUID(){
    if(this.uuid == null){
      this.uuid = UUID.randomUUID().toString();
    }
  }

  @Override
  public void update(FoodUpdateEntitiesDTO dto) {
    this.name = Objects.requireNonNullElse(dto.getName(), this.name);
    this.description = Objects.requireNonNullElse(dto.getDescription(), this.description);
    this.carbs = Objects.requireNonNullElse(dto.getCarbs(), this.carbs);
    this.proteins = Objects.requireNonNullElse(dto.getProteins(), this.proteins);
    this.fats = Objects.requireNonNullElse(dto.getFats(), this.fats);
    this.saturated_fats = Objects.requireNonNullElse(dto.getSaturated_fats(), this.saturated_fats);
    this.sodium = Objects.requireNonNullElse(dto.getSodium(), this.sodium);
    this.dietary_fiber = Objects.requireNonNullElse(dto.getDietary_fiber(), this.dietary_fiber);
    this.serving_amount = Objects.requireNonNullElse(dto.getServing_amount(), this.serving_amount);
    this.image_url = Objects.requireNonNullElse(dto.getImage_url(), this.image_url);
  }
  
}

