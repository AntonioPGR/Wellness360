package com.wellness360.nutrition.app.recipe.dtos;

import java.util.List;

import com.wellness360.nutrition.app.recipe.ingredient.dto.IngredientCreateIdsDTO;
import com.wellness360.nutrition.app.recipe.media.dtos.MediaCreateFileDTO;
import com.wellness360.nutrition.app.recipe.section.dtos.SectionCreateIdsDTO;

import jakarta.annotation.Nullable;
import lombok.Getter;
import lombok.NonNull;

@Getter
public class RecipeCreateIdsDTO {
  @NonNull
  String name;
  @Nullable
  String description;
  @NonNull
  String user_uuid;
  @NonNull
  String tag_uuid;
  @NonNull
  String category_uuid;
  @NonNull
  List<IngredientCreateIdsDTO> ingredients;
  @NonNull
  List<MediaCreateFileDTO> media;
  @NonNull
  List<SectionCreateIdsDTO> sections;
}
