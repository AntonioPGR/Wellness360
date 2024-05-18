package com.wellness360.nutrition.app.recipe.ingredient.dto;

import jakarta.annotation.Nonnull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IngredientCreateRequestDTO {
  @Nonnull
  String food_uuid;
  @Nonnull
  String amount;
}
