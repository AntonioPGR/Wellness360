package com.wellness360.nutrition.app.recipe.ingredient.dto;

import jakarta.annotation.Nonnull;
import lombok.Getter;

@Getter
public class IngredientCreateIdsDTO {
  @Nonnull
  String food_uuid;
  @Nonnull
  Short amount;
}
