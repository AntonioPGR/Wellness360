package com.wellness360.nutrition.app.recipe.dtos;

import java.util.List;

import com.wellness360.nutrition.common.interfaces.UuidDTO;
import com.wellness360.nutrition.app.recipe.ingredient.dto.IngredientUpdateIdsDTO;
import com.wellness360.nutrition.app.recipe.media.dtos.MediaUpdateFileDTO;
import com.wellness360.nutrition.app.recipe.section.dtos.SectionUpdateIdsDTO;

import jakarta.annotation.Nullable;
import lombok.Getter;
import lombok.NonNull;

@Getter
public class RecipeUpdateIdsDTO implements UuidDTO {
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
  List<IngredientUpdateIdsDTO> ingredients;
  @Nullable
  List<MediaUpdateFileDTO> media;
  @Nullable
  List<SectionUpdateIdsDTO> sections;
}
