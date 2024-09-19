package com.wellness360.nutrition.app.recipe.dtos;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.wellness360.nutrition.app.recipe.ingredient.dto.IngredientCreateRequestDTO;
import com.wellness360.nutrition.app.recipe.section.dtos.SectionCreateRequestDTO;
import com.wellness360.nutrition.packages.crud.dtos.CrudCreateRequestDTO;
import com.wellness360.nutrition.validation.Validator;

public record RecipeCreateRequestDTO(
  String name,
  String description,
  String user_uuid,
  String tag_uuid,
  String category_uuid,
  List<MultipartFile> media,
  List<IngredientCreateRequestDTO> ingredients,
  List<SectionCreateRequestDTO> sections
) implements CrudCreateRequestDTO {

  public void validate(Validator validator) {
    validator.string.validateName(name);
    validator.string.validateText(description, true);
    validator.string.validateUuid(user_uuid);
    validator.string.validateUuid(tag_uuid);
    validator.string.validateUuid(category_uuid);
    media.forEach(image -> validator.media.validateImage(image));
    ingredients.forEach(ingredient -> ingredient.validate(validator));
    sections.forEach(sections -> sections.validate(validator));
  }
}
