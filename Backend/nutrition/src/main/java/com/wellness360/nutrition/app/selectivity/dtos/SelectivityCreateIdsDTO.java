package com.wellness360.nutrition.app.selectivity.dtos;

import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import lombok.Getter;


@Getter
public class SelectivityCreateIdsDTO{
  @Nonnull
  String user_uuid;
  @Nullable
  String recipe_uuid;
  @Nullable
  String food_uuid;
  @Nullable
  String category_uuid;
}

