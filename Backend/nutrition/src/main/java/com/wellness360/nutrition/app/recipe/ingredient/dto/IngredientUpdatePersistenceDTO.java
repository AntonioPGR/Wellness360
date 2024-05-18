package com.wellness360.nutrition.app.recipe.ingredient.dto;

import com.wellness360.nutrition.app.food.FoodEntity;
import com.wellness360.nutrition.app.recipe.RecipeEntity;
import com.wellness360.nutrition.common.crud_bases.interfaces.UuidDTO;

import io.micrometer.common.lang.Nullable;
import jakarta.annotation.Nonnull;
import lombok.Getter;

@Getter
public class IngredientUpdatePersistenceDTO implements UuidDTO {
  @Nonnull
  String uuid;
  @Nonnull
  RecipeEntity recipe;
  @Nullable
  FoodEntity food;
  @Nullable
  Short amount;

  public IngredientUpdatePersistenceDTO(IngredientUpdateRequestDTO dto, FoodEntity food, RecipeEntity recipe) {
    this.uuid = dto.getUuid();
    this.amount = dto.getAmount();
    this.food = food;
    this.recipe = recipe;
  }

}
