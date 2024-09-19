package com.wellness360.nutrition.app.selectivity.dtos;

import com.wellness360.nutrition.app.category.CategoryEntity;
import com.wellness360.nutrition.app.food.FoodEntity;
import com.wellness360.nutrition.app.recipe.RecipeEntity;
import com.wellness360.nutrition.packages.crud.dtos.CrudCreatePersistenceDTO;

public record SelectivityCreatePersistenceDTO(
  String user_uuid,
  RecipeEntity recipe,
  FoodEntity food,
  CategoryEntity category
) implements CrudCreatePersistenceDTO{
}

