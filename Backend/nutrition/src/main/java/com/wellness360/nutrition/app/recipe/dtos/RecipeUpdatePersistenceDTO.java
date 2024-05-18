package com.wellness360.nutrition.app.recipe.dtos;

import com.wellness360.nutrition.app.category.CategoryEntity;
import com.wellness360.nutrition.app.tag.TagEntity;
import com.wellness360.nutrition.common.crud_bases.interfaces.UuidDTO;

import jakarta.annotation.Nullable;
import lombok.Getter;
import lombok.NonNull;

@Getter
public class RecipeUpdatePersistenceDTO implements UuidDTO {
  @NonNull
  String uuid;
  @Nullable
  String name;
  @Nullable
  String description;
  @Nullable
  String user_uuid;
  @Nullable
  TagEntity tag;
  @Nullable
  CategoryEntity category;

  public RecipeUpdatePersistenceDTO(RecipeUpdateRequestDTO dto, TagEntity tag, CategoryEntity category) {
    this.uuid = dto.getUuid();
    this.name = dto.getName();
    this.description = dto.getDescription();
    this.user_uuid = dto.getUser_uuid();
    this.tag = tag;
    this.category = category;
  }

}
