package com.wellness360.nutrition.app.recipe.dtos;

import java.util.List;

import com.wellness360.nutrition.app.recipe.ingredient.dto.IngredientUpdateRequestDTO;
import com.wellness360.nutrition.app.recipe.media.dtos.MediaUpdateRequestDTO;
import com.wellness360.nutrition.app.recipe.section.dtos.SectionUpdateRequestDTO;
import com.wellness360.nutrition.common.crud_bases.interfaces.UuidDTO;

import jakarta.annotation.Nullable;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
public class RecipeUpdateRequestDTO implements UuidDTO {
  @NonNull
  String uuid;
  @Nullable
  String name;
  @Nullable
  String description;
  @Nullable
  String user_uuid;
  @Nullable
  String tag_uuid;
  @Nullable
  String category_uuid;
  @Nullable
  List<IngredientUpdateRequestDTO> ingredients;
  @Nullable
  List<MediaUpdateRequestDTO> media;
  @Nullable
  List<SectionUpdateRequestDTO> sections;
}
