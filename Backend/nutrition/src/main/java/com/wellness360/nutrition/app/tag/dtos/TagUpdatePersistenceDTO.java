package com.wellness360.nutrition.app.tag.dtos;

import com.wellness360.nutrition.app.category.CategoryEntity;
import com.wellness360.nutrition.common.dtos.UuidDTO;

import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import lombok.Getter;

@Getter
public class TagUpdatePersistenceDTO implements UuidDTO{
  @Nonnull
  String uuid;
  @Nullable
  String name; 
  @Nullable
  String description;
  @Nullable
  String image_url;
  @Nullable
  CategoryEntity category;
  
  public TagUpdatePersistenceDTO(TagUpdateRequestDTO id_dto, CategoryEntity category_entity, String image_url) {
    this.uuid = id_dto.getUuid();
    this.name = id_dto.getName();
    this.description = id_dto.getDescription();
    this.image_url = image_url;
    this.category = category_entity;
  }

}