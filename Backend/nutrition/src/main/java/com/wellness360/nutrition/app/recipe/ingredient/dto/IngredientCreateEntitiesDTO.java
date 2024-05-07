package com.wellness360.nutrition.app.recipe.ingredient.dto;

import com.wellness360.nutrition.app.food.FoodEntity;
import com.wellness360.nutrition.app.recipe.RecipeEntity;

import jakarta.annotation.Nonnull;
import lombok.Getter;

@Getter
public class IngredientCreateEntitiesDTO {
  @Nonnull
  FoodEntity food;
  @Nonnull
  RecipeEntity recipe;
  @Nonnull
  Short amount;

  public IngredientCreateEntitiesDTO(IngredientCreateIdsDTO dto, FoodEntity food, RecipeEntity recipe) {
    this.amount = dto.getAmount();
    this.food = food;
    this.recipe = recipe;
  }

}
