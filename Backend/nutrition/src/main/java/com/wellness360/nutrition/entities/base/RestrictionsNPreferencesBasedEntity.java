package com.wellness360.nutrition.entities.base;

import com.wellness360.nutrition.entities.CategoryEntity;
import com.wellness360.nutrition.entities.FoodEntity;
import com.wellness360.nutrition.entities.RecipeEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Inheritance
@Entity
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class RestrictionsNPreferencesBasedEntity extends IdNUuidBasedEntity {

  @Column(name = "user_id")
  private Long userId;
  
  @ManyToOne
  @JoinColumn(name = "recipe_id", referencedColumnName = "id", insertable = false, updatable = false)
  private RecipeEntity recipe;
  
  @ManyToOne
  @JoinColumn(name = "food_id", referencedColumnName = "id", insertable = false, updatable = false)
  private FoodEntity food;
  
  @ManyToOne
  @JoinColumn(name = "category_id", referencedColumnName = "id", insertable = false, updatable = false)
  private CategoryEntity category;
}
