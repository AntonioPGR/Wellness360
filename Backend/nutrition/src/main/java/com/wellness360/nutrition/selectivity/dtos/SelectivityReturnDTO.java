package com.wellness360.nutrition.selectivity.dtos;

import com.wellness360.nutrition.category.dtos.CategoryReturnDTO;
import com.wellness360.nutrition.food.dtos.FoodReturnDTO;
import com.wellness360.nutrition.recipe.dtos.RecipeReturnDTO;
import com.wellness360.nutrition.selectivity.SelectivityBaseEntity;
import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import lombok.Getter;

@Getter
public class SelectivityReturnDTO{
  @Nonnull
  String uuid;
  @Nullable
  RecipeReturnDTO recipe;
  @Nullable
  FoodReturnDTO food;
  @Nullable
  CategoryReturnDTO category;

  public SelectivityReturnDTO(SelectivityBaseEntity entity){
    this.uuid = entity.getUuid();
    this.recipe = new RecipeReturnDTO(entity.getRecipe());
    this.food = new FoodReturnDTO(entity.getFood());
    this.category = new CategoryReturnDTO(entity.getCategory());
  }

}

