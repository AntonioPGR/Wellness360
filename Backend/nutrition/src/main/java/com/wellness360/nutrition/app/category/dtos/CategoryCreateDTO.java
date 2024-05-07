package com.wellness360.nutrition.app.category.dtos;

import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CategoryCreateDTO {
  @Nonnull
  protected String name;
  @Nullable
  protected String description;
  @Nonnull
  protected String image_url;
}
