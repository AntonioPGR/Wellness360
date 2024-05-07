package com.wellness360.nutrition.app.tag.dtos;

import com.wellness360.nutrition.app.category.CategoryEntity;

import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import lombok.Getter;

@Getter
public class TagCreateEntitiesDTO{
  @Nonnull
  String name; 
  @Nullable
  String description;
  @Nonnull
  String image_url;
  @Nonnull
  CategoryEntity category;

  public TagCreateEntitiesDTO(TagCreateIdsDTO id_dto, CategoryEntity refered_category) {
    this.name = id_dto.name;
    this.description = id_dto.description;
    this.image_url = id_dto.image_url;
    this.category = refered_category;
  }
}

