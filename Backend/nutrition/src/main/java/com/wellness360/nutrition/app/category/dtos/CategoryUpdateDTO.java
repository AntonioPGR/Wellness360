package com.wellness360.nutrition.app.category.dtos;

import com.wellness360.nutrition.common.interfaces.UuidDTO;

import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import lombok.Getter;

@Getter
public class CategoryUpdateDTO implements UuidDTO {
  @Nonnull
  protected String uuid;
  @Nullable
  protected String name;
  @Nullable
  protected String description;
  @Nullable
  protected String image_url;
}
