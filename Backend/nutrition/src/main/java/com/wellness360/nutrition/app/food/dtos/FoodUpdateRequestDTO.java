package com.wellness360.nutrition.app.food.dtos;

import org.springframework.web.multipart.MultipartFile;

import com.wellness360.nutrition.common.crud_bases.interfaces.UuidDTO;

import io.micrometer.common.lang.Nullable;
import jakarta.annotation.Nonnull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter(value = AccessLevel.PUBLIC)
public class FoodUpdateRequestDTO implements UuidDTO{
  @Nonnull
  String uuid;
  @Nullable
  String name;
  @Nullable
  String description;
  @Nullable
  Float carbs;
  @Nullable
  Float proteins;
  @Nullable
  Float fats;
  @Nullable
  Float saturated_fats;
  @Nullable
  Float sodium;
  @Nullable
  Float dietary_fiber;
  @Nullable
  Short serving_amount;
  @Nullable
  MultipartFile image;
  @Nullable
  String tag_uuid;
  @Nullable
  String category_uuid;
}
