package com.wellness360.nutrition.food.dtos;

import com.wellness360.common.interfaces.CrudUpdateDTO;
import io.micrometer.common.lang.Nullable;
import jakarta.annotation.Nonnull;
import lombok.Getter;

@Getter
public class FoodUpdateIdsDTO implements CrudUpdateDTO{
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
  String image_url;
  @Nullable
  String tag_uuid;
  @Nullable
  String category_uuid;
}
