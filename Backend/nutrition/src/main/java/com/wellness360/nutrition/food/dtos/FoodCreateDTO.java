package com.wellness360.nutrition.food.dtos;

import io.micrometer.common.lang.Nullable;
import jakarta.annotation.Nonnull;

public record FoodCreateDTO(
  @Nonnull
  String name,
  @Nullable
  String description,
  @Nonnull
  Float carbs,
  @Nonnull
  Float proteins,
  @Nonnull
  Float fats,
  @Nonnull
  Float saturated_fats,
  @Nonnull
  Float sodium,
  @Nonnull
  Float dietaryFiber,
  @Nonnull
  Short servingAmount
) {
}
