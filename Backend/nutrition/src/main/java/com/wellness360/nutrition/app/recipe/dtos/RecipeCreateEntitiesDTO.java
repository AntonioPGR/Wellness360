package com.wellness360.nutrition.app.recipe.dtos;

import java.util.Set;

import com.wellness360.nutrition.app.category.CategoryEntity;
import com.wellness360.nutrition.app.recipe.ingredient.IngredientEntity;
import com.wellness360.nutrition.app.recipe.media.MediaEntity;
import com.wellness360.nutrition.app.recipe.section.SectionEntity;
import com.wellness360.nutrition.app.tag.TagEntity;

import jakarta.annotation.Nullable;
import lombok.Getter;
import lombok.NonNull;

@Getter
public class RecipeCreateEntitiesDTO {
  @NonNull
  String name;
  @Nullable
  String description;
  @NonNull
  String user_uuid;
  @NonNull
  TagEntity tag;
  @NonNull
  CategoryEntity category;
  @NonNull
  Set<MediaEntity> media;
  @NonNull
  Set<IngredientEntity> ingredients;
  @NonNull
  Set<SectionEntity> sections;

  public RecipeCreateEntitiesDTO(
    RecipeCreateIdsDTO dto, 
    TagEntity tag, 
    CategoryEntity category
  ){
    this.name = dto.getName();
    this.description = dto.getDescription();
    this.user_uuid = dto.getUser_uuid();
    this.tag = tag;
    this.category = category;
  }

}
