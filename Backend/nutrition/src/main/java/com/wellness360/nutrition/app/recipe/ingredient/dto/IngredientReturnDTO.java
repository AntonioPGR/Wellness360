package com.wellness360.nutrition.app.recipe.ingredient.dto;

import com.wellness360.nutrition.app.food.dtos.FoodReturnDTO;
import com.wellness360.nutrition.app.recipe.ingredient.IngredientEntity;

import jakarta.annotation.Nonnull;

public class IngredientReturnDTO {
  @Nonnull
  String uuid;
  @Nonnull
  FoodReturnDTO food;
  @Nonnull
  Short amount;

  public IngredientReturnDTO(IngredientEntity entity){
    uuid = entity.getUuid();
    food = new FoodReturnDTO(entity.getFood());
    amount = entity.getAmount();
  }

}
