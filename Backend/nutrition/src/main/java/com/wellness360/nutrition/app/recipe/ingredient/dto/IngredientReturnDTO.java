package com.wellness360.nutrition.app.recipe.ingredient.dto;

import com.wellness360.nutrition.app.food.dtos.FoodReturnDTO;

public record IngredientReturnDTO(
  String uuid,
  FoodReturnDTO food,
  Short amount
){
}
