package com.wellness360.nutrition.app.tag.dtos;

import com.wellness360.nutrition.app.category.CategoryEntity;

import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import lombok.Getter;

@Getter
public class TagCreatePersistenceDTO{
  @Nonnull
  String name; 
  @Nullable
  String description;
  @Nonnull
  String image_url;
  @Nonnull
  CategoryEntity category;

  public TagCreatePersistenceDTO(TagCreateRequestDTO id_dto, String file_path, CategoryEntity refered_category) {
    this.name = id_dto.name;
    this.description = id_dto.description;
    this.image_url = file_path;
    this.category = refered_category;
  }
}

