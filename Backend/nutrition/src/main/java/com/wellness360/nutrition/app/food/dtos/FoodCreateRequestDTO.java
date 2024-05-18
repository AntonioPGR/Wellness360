package com.wellness360.nutrition.app.food.dtos;

import org.springframework.web.multipart.MultipartFile;

import io.micrometer.common.lang.Nullable;
import jakarta.annotation.Nonnull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter(value = AccessLevel.PUBLIC)
public class FoodCreateRequestDTO{
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
  MultipartFile image;
  @Nonnull
  String tag_uuid;
  @Nonnull
  String category_uuid;
}
