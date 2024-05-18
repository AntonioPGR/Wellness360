package com.wellness360.nutrition.app.category.dtos;

import com.wellness360.nutrition.app.category.CategoryEntity;
import com.wellness360.nutrition.common.crud_bases.interfaces.UuidDTO;

import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class CategoryReturnDTO implements UuidDTO {
  @Nonnull
  protected String uuid;
  @Nonnull
  protected String name;
  @Nullable
  protected String description;
  @Nonnull
  protected String image_url;

  public CategoryReturnDTO(CategoryEntity entity) {
    this.uuid = entity.getUuid();
    this.name = entity.getName();
    this.description = entity.getDescription();
    this.image_url = entity.getImage_url();
  }

}
