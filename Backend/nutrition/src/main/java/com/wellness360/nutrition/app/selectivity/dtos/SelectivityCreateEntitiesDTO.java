package com.wellness360.nutrition.app.selectivity.dtos;

import com.wellness360.nutrition.app.category.CategoryEntity;
import com.wellness360.nutrition.app.food.FoodEntity;
import com.wellness360.nutrition.app.recipe.RecipeEntity;

import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public class SelectivityCreateEntitiesDTO{
  @Nonnull
  Long user_uuid;
  @Nullable
  RecipeEntity recipe;
  @Nullable
  FoodEntity food;
  @Nullable
  CategoryEntity category;
}

