package com.wellness360.nutrition.category.dtos;

import com.wellness360.nutrition.category.CategoryEntity;
import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class CategoryReturnDTO {
  @Nonnull
  private String uuid;
  @Nonnull
  private String name;
  @Nullable
  private String description;
  @Nonnull
  private String image_url;

  public CategoryReturnDTO(CategoryEntity entity) {
    this.uuid = entity.getUuid();
    this.name = entity.getName();
    this.description = entity.getDescription();
    this.image_url = entity.getImage_url();
  }

}
