package com.wellness360.nutrition.food.dtos;

import io.micrometer.common.lang.Nullable;
import jakarta.annotation.Nonnull;
import lombok.Getter;

@Getter
public class FoodCreateIdsDTO{
  @Nonnull
  String name;
  @Nullable
  String description;
  @Nonnull
  Float carbs;
  @Nonnull
  Float proteins;
  @Nonnull
  Float fats;
  @Nonnull
  Float saturated_fats;
  @Nonnull
  Float sodium;
  @Nonnull
  Float dietary_fiber;
  @Nonnull
  Short serving_amount;
  @Nonnull
  String image_url;
  @Nonnull
  String tag_uuid;
  @Nonnull
  String category_uuid;
}
