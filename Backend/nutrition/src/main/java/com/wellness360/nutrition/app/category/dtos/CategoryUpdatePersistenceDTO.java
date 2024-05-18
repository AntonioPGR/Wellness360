package com.wellness360.nutrition.app.category.dtos;

import com.wellness360.nutrition.common.crud_bases.interfaces.UuidDTO;

import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import lombok.Getter;

@Getter
public class CategoryUpdatePersistenceDTO implements UuidDTO {
  @Nonnull
  protected String uuid;
  @Nullable
  protected String name;
  @Nullable
  protected String description;
  @Nullable
  protected String image_path;

  public CategoryUpdatePersistenceDTO(CategoryUpdateRequestDTO request_dto, String image_path) {
    this.uuid = request_dto.getUuid();
    this.name = request_dto.getName();
    this.description = request_dto.getDescription();
    this.image_path = image_path;
  }
}
