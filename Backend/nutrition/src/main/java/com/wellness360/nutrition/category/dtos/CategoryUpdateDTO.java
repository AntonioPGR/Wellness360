package com.wellness360.nutrition.category.dtos;

import com.wellness360.common.interfaces.CrudUpdateDTO;

import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import lombok.Getter;

@Getter
public class CategoryUpdateDTO implements CrudUpdateDTO {
  @Nonnull
  private String uuid;
  @Nullable
  private String name;
  @Nullable
  private String description;
  @Nullable
  private String image_url;
}
