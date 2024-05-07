package com.wellness360.nutrition.app.recipe.ingredient.dto;

import com.wellness360.nutrition.app.food.FoodEntity;
import com.wellness360.nutrition.app.recipe.RecipeEntity;
import com.wellness360.nutrition.common.interfaces.UuidDTO;

import io.micrometer.common.lang.Nullable;
import jakarta.annotation.Nonnull;
import lombok.Getter;

@Getter
public class IngredientUpdateEntitiesDTO implements UuidDTO {
  @Nonnull
  String uuid;
  @Nonnull
  RecipeEntity recipe;
  @Nullable
  FoodEntity food;
  @Nullable
  Short amount;

  public IngredientUpdateEntitiesDTO(IngredientUpdateIdsDTO dto, FoodEntity food, RecipeEntity recipe) {
    this.uuid = dto.getUuid();
    this.amount = dto.getAmount();
    this.food = food;
    this.recipe = recipe;
  }

}
