package com.wellness360.nutrition.app.tag.dtos;

import com.wellness360.nutrition.app.tag.TagEntity;

import jakarta.annotation.Nullable;
import lombok.Getter;
import lombok.NonNull;

@Getter
public class TagReturnOnlyDTO{
  @NonNull
  String uuid;
  @NonNull
  String name; 
  @Nullable
  String description;
  @NonNull
  String image_url;

  public TagReturnOnlyDTO(TagEntity entity) {
    this.uuid = entity.getUuid();
    this.name = entity.getName();
    this.description = entity.getDescription();
    this.image_url = entity.getImage_url();
  }

}