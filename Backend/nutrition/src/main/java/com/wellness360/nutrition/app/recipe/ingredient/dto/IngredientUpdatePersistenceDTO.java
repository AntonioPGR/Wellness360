package com.wellness360.nutrition.app.recipe.ingredient.dto;

import com.wellness360.nutrition.app.food.FoodEntity;
import com.wellness360.nutrition.app.recipe.RecipeEntity;
import com.wellness360.nutrition.packages.crud.dtos.CrudUpdatePersistenceDTO;

public record IngredientUpdatePersistenceDTO(
  String uuid,
  RecipeEntity recipe,
  FoodEntity food,
  Short amount
) implements CrudUpdatePersistenceDTO {
}
