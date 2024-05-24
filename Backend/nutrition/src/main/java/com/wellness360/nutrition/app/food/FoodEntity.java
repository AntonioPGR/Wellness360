package com.wellness360.nutrition.app.food;

import java.util.Objects;
import java.util.Set;

import com.wellness360.nutrition.common.entities.NamedDescribedImageEntity;
import com.wellness360.nutrition.common.interfaces.INameEntity;
import com.wellness360.nutrition.common.tools.MacroNutrientsCalculator;
import com.wellness360.nutrition.app.category.CategoryEntity;
import com.wellness360.nutrition.app.food.dtos.FoodCreatePersistenceDTO;
import com.wellness360.nutrition.app.food.dtos.FoodUpdatePersistenceDTO;
import com.wellness360.nutrition.app.recipe.ingredient.IngredientEntity;
import com.wellness360.nutrition.app.selectivity.preference.PreferenceEntity;
import com.wellness360.nutrition.app.selectivity.restriction.RestrictionEntity;
import com.wellness360.nutrition.app.tag.TagEntity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "food")
@Getter
@Setter(value = AccessLevel.PROTECTED)
@AllArgsConstructor
@NoArgsConstructor
public class FoodEntity extends NamedDescribedImageEntity implements INameEntity<FoodUpdatePersistenceDTO>{

  // COLUMNS
  @Column(name = "calories", nullable = false)
  protected Short calories;

  @Column(name = "carbs", nullable = false)
  protected Float carbs;

  @Column(name = "proteins", nullable = false)
  protected Float proteins;

  @Column(name = "fats", nullable = false)
  protected Float fats;

  @Column(name = "saturated_fats", nullable = false)
  protected Float saturated_fats;

  @Column(name = "sodium", nullable = false)
  protected Float sodium;

  @Column(name = "dietary_fiber", nullable = false)
  protected Float dietary_fiber;

  @Column(name = "serving_amount", nullable = false)
  protected Short serving_amount = 100;

  // RELATIONSHIPS
  @ManyToOne
  @NonNull
  @JoinColumn(name = "tag_id" )
  protected TagEntity tag;

  @ManyToOne
  @NonNull
  @JoinColumn(name = "category_id")
  protected CategoryEntity category;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "food")
  protected Set<IngredientEntity> recipes;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "food")
  protected Set<PreferenceEntity> preferences;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "food")
  protected Set<RestrictionEntity> restricions;

  // CONSTRUCTORS
  public FoodEntity(FoodCreatePersistenceDTO dto) {
    this.name = dto.getName();
    this.description = dto.getDescription();
    this.image_url = dto.getImage_url();
    this.tag = dto.getTag();
    this.category = dto.getCategory();

    // Equalized properties
    MacroNutrientsCalculator equalizer = new MacroNutrientsCalculator(dto.getServing_amount(), this.serving_amount);
    this.carbs = equalizer.equalizeToNewAmount(dto.getCarbs());
    this.proteins = equalizer.equalizeToNewAmount(dto.getProteins());
    this.fats = equalizer.equalizeToNewAmount(dto.getFats());
    this.saturated_fats = equalizer.equalizeToNewAmount(dto.getSaturated_fats());
    this.sodium = equalizer.equalizeToNewAmount(dto.getSodium());
    this.dietary_fiber = equalizer.equalizeToNewAmount(dto.getDietary_fiber());

    this.calories = MacroNutrientsCalculator.calculateCalories(this.carbs, this.proteins, this.fats);
  }

  // INHERIT
  @Override
  public void update(FoodUpdatePersistenceDTO dto) {
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

