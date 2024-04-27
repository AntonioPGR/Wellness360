package com.wellness360.nutrition.tag.dtos;

import com.wellness360.common.interfaces.CrudUpdateDTO;
import com.wellness360.nutrition.category.CategoryEntity;

import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import lombok.Getter;

@Getter
public class TagUpdateEntitiesDTO implements CrudUpdateDTO{
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
  
  public TagUpdateEntitiesDTO(TagUpdateIdsDTO id_dto, CategoryEntity category_entity) {
    this.uuid = id_dto.getUuid();
    this.name = id_dto.getName();
    this.description = id_dto.getDescription();
    this.image_url = id_dto.getImage_url();
    this.category = category_entity;
  }

}