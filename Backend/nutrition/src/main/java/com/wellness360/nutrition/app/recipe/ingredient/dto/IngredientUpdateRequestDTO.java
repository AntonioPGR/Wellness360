package com.wellness360.nutrition.app.recipe.ingredient.dto;

import com.wellness360.nutrition.common.crud_bases.interfaces.UuidDTO;

import io.micrometer.common.lang.Nullable;
import jakarta.annotation.Nonnull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IngredientUpdateRequestDTO implements UuidDTO {
  @Nonnull
  String uuid;
  @Nullable
  String food_uuid;
  @Nullable
  Short amount;
}
