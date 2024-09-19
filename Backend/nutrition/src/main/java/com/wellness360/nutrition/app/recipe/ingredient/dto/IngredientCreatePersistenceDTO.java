package com.wellness360.nutrition.app.recipe.ingredient.dto;

import com.wellness360.nutrition.app.food.FoodEntity;
import com.wellness360.nutrition.app.recipe.RecipeEntity;
import com.wellness360.nutrition.packages.crud.dtos.CrudCreatePersistenceDTO;

public record IngredientCreatePersistenceDTO(
  FoodEntity food,
  RecipeEntity recipe,
  short amount
) implements CrudCreatePersistenceDTO{
}
