package com.wellness360.nutrition.food;

import java.util.Set;
import java.util.UUID;

import com.wellness360.nutrition.category.CategoryEntity;
import com.wellness360.nutrition.preference.PreferenceEntity;
import com.wellness360.nutrition.recipe.RecipeIngredientEntity;
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
public class FoodEntity{

  // ATRIBUTES
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  
  @Column(name = "uuid", unique = true, nullable = false, length = 36)
  private UUID uuid;

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
  private Float dietaryFiber;

  @Column(name = "serving_amount", nullable = false)
  private Short servingAmount;

  // RELATIONSHIPS
  @ManyToOne
  @JoinColumn(name = "tag_id",   insertable = false, updatable = false)
  private TagEntity tag;

  @ManyToMany
  @JoinTable(
    name = "food_category",
    joinColumns = @JoinColumn(name="food_id"),
    inverseJoinColumns = @JoinColumn(name = "category_id")
  )
  private Set<CategoryEntity> categories;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "food")
  private Set<RecipeIngredientEntity> recipes;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "food")
  private Set<PreferenceEntity> preferences;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "food")
  private Set<RestrictionEntity> restricions;

  @PrePersist
  private void initializeUUID(){
    if(this.uuid == null){
      this.uuid = UUID.randomUUID();
    }
  }
}

