package com.wellness360.nutrition.app.category.dtos;

import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import lombok.Getter;

@Getter
public class CategoryCreatePersistenceDTO {
  @Nonnull
  protected String name;
  @Nullable
  protected String description;
  @Nonnull
  protected String image_path;

  public CategoryCreatePersistenceDTO(CategoryCreateRequestDTO request_dto, String image_path) {
    this.name = request_dto.getName();
    this.description = request_dto.getDescription();
    this.image_path = image_path;
  }

}
