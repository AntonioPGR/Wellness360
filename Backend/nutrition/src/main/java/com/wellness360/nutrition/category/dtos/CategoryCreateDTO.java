package com.wellness360.nutrition.category.dtos;

import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CategoryCreateDTO {
  @Nonnull
  private String name;
  @Nullable
  private String description;
  @Nonnull
  private String image_url;
}
