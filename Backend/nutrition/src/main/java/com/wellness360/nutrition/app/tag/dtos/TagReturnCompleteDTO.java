package com.wellness360.nutrition.app.tag.dtos;

import com.wellness360.nutrition.app.category.dtos.CategoryReturnDTO;
import com.wellness360.nutrition.app.tag.TagEntity;
import com.wellness360.nutrition.common.dtos.UuidDTO;

import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import lombok.Getter;
import lombok.NonNull;

@Getter
public class TagReturnCompleteDTO implements UuidDTO{
  @NonNull
  String uuid;
  @NonNull
  String name; 
  @Nullable
  String description;
  @NonNull
  String image_url;
  @Nonnull
  CategoryReturnDTO category;

  public TagReturnCompleteDTO(TagEntity entity) {
    this.uuid = entity.getUuid();
    this.name = entity.getName();
    this.description = entity.getDescription();
    this.image_url = entity.getImage_url();
    this.category = new CategoryReturnDTO(entity.getCategory());
  }

}