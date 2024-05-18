package com.wellness360.nutrition.app.recipe.ingredient.dto;

import com.wellness360.nutrition.app.food.FoodEntity;
import com.wellness360.nutrition.app.recipe.RecipeEntity;

import jakarta.annotation.Nonnull;
import lombok.Getter;

@Getter
public class IngredientCreatePersistenceDTO {
  @Nonnull
  FoodEntity food;
  @Nonnull
  RecipeEntity recipe;
  @Nonnull
  Integer amount;

  public IngredientCreatePersistenceDTO(IngredientCreateRequestDTO dto, FoodEntity food, RecipeEntity recipe) {
    this.amount = Integer.parseInt(dto.getAmount());
    this.food = food;
    this.recipe = recipe;
  }

}
