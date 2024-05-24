package com.wellness360.nutrition.app.recipe.dtos;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.wellness360.nutrition.app.recipe.ingredient.dto.IngredientCreateRequestDTO;
import com.wellness360.nutrition.app.recipe.section.dtos.SectionCreateRequestDTO;
import com.wellness360.nutrition.common.dtos.ValidatableDTO;
import com.wellness360.nutrition.common.services.ValidateService;

import jakarta.annotation.Nullable;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
public class RecipeCreateRequestDTO implements ValidatableDTO {
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

  public void validate(ValidateService validator) {
    validator.validateName(name);
    validator.validateText(description);
    validator.validateUuid(user_uuid);
    validator.validateUuid(tag_uuid);
    validator.validateUuid(category_uuid);
    media.forEach(image -> validator.validateImage(image));
    ingredients.forEach(ingredient -> ingredient.validate(validator));
    sections.forEach(sections -> sections.validate(validator));
  }
}
