package com.wellness360.nutrition.entities;

import com.wellness360.nutrition.entities.base.IdNUuidBasedEntity;
import jakarta.persistence.*;

@Table(name = "preferences")
public class PreferenceEntity extends IdNUuidBasedEntity {

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

