package com.wellness360.nutrition.app.recipe.ingredient.dto;

import io.micrometer.common.lang.Nullable;
import jakarta.annotation.Nonnull;
import lombok.Getter;

@Getter
public class IngredientUpdateIdsDTO {
  @Nonnull
  String uuid;
  @Nullable
  String food_uuid;
  @Nullable
  Short amount;
}
