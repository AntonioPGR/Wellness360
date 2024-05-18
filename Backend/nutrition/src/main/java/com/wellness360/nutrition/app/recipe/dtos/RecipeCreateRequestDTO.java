package com.wellness360.nutrition.app.recipe.dtos;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.wellness360.nutrition.app.recipe.ingredient.dto.IngredientCreateRequestDTO;
import com.wellness360.nutrition.app.recipe.section.dtos.SectionCreateRequestDTO;

import jakarta.annotation.Nullable;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
public class RecipeCreateRequestDTO {
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
  List<IngredientCreateRequestDTO> ingredients;
  @NonNull
  List<MultipartFile> media;
  @NonNull
  List<SectionCreateRequestDTO> sections;
}
