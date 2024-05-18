package com.wellness360.nutrition.app.recipe.dtos;

import java.util.List;

import com.wellness360.nutrition.app.category.dtos.CategoryReturnDTO;
import com.wellness360.nutrition.app.recipe.RecipeEntity;
import com.wellness360.nutrition.app.recipe.ingredient.dto.IngredientReturnDTO;
import com.wellness360.nutrition.app.recipe.media.dtos.MediaReturnDTO;
import com.wellness360.nutrition.app.recipe.section.dtos.SectionReturnDTO;
import com.wellness360.nutrition.app.tag.dtos.TagReturnSimplifiedDTO;
import com.wellness360.nutrition.common.crud_bases.interfaces.UuidDTO;

import jakarta.annotation.Nullable;
import lombok.Getter;
import lombok.NonNull;

@Getter
public class RecipeReturnDTO implements UuidDTO {
  @NonNull
  String uuid;
  @NonNull
  String name;
  @Nullable
  String description;
  @NonNull
  String user_uuid;
  @NonNull
  TagReturnSimplifiedDTO tag;
  @NonNull
  CategoryReturnDTO category;
  @NonNull
  List<IngredientReturnDTO> ingredients;
  @NonNull
  List<MediaReturnDTO> media;
  @NonNull
  List<SectionReturnDTO> sections;
  
  @SuppressWarnings("static-access")
  public RecipeReturnDTO(RecipeEntity recipe) {
    this.uuid = recipe.getUuid();
    this.name = recipe.getName();
    this.description = recipe.getDescription();
    this.user_uuid = recipe.getPost_user_id().toString(0);
    this.tag = new TagReturnSimplifiedDTO(recipe.getTag());
    this.category = new CategoryReturnDTO(recipe.getCategory());

    this.ingredients = recipe.getIngredients() != null? recipe.getIngredients().stream().map(IngredientReturnDTO::new).toList() : null;
    this.media = recipe.getMedia() != null? recipe.getMedia().stream().map(MediaReturnDTO::new).toList() : null;
    this.sections = recipe.getSections() != null? recipe.getSections().stream().map(SectionReturnDTO::new).toList() : null;
  }

}
