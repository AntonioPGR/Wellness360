package com.wellness360.nutrition.app.selectivity.dtos;

import com.wellness360.nutrition.app.category.dtos.CategoryReturnDTO;
import com.wellness360.nutrition.app.food.dtos.FoodReturnDTO;
import com.wellness360.nutrition.app.recipe.dtos.RecipeReturnDTO;
import com.wellness360.nutrition.packages.crud.dtos.CrudReturnDTO;

public record SelectivityReturnDTO(
  String uuid,
  RecipeReturnDTO recipe,
  FoodReturnDTO food,
  CategoryReturnDTO category
) implements CrudReturnDTO{
}

