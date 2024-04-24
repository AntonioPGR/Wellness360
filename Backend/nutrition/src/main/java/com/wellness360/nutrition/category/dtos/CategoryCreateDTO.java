package com.wellness360.nutrition.category.dtos;

import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CategoryCreateDTO {
  @Nonnull
  private String name;
  @Nullable
  private String description;
  @Nonnull
  private String image_url;
}
