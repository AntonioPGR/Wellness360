package com.wellness360.nutrition.selectivity;

import com.wellness360.common.Entities.BaseIdsEntity;
import com.wellness360.nutrition.category.CategoryEntity;
import com.wellness360.nutrition.food.FoodEntity;
import com.wellness360.nutrition.recipe.RecipeEntity;
import com.wellness360.nutrition.selectivity.dtos.SelectivityCreateEntitiesDTO;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;

@MappedSuperclass
@Getter
public abstract class SelectivityBaseEntity extends BaseIdsEntity {

  @Column(name = "user_id", nullable = false)
  protected Long userId;
  
  @ManyToOne
  @JoinColumn(name = "recipe_id", nullable = true)
  protected RecipeEntity recipe;
  
  @ManyToOne
  @JoinColumn(name = "food_id", nullable = true)
  protected FoodEntity food;
  
  @ManyToOne
  @JoinColumn(name = "category_id", nullable = true)
  protected CategoryEntity category;

  public SelectivityBaseEntity(SelectivityCreateEntitiesDTO create_dto) {
    this.userId = 1L;
    this.food = create_dto.getFood();
    this.category = create_dto.getCategory();
    this.recipe = create_dto.getRecipe();
  }

}
