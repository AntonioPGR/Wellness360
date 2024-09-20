package com.wellness360.nutrition.app.recipe.dtos;

import java.util.List;

import com.wellness360.nutrition.app.recipe.ingredient.dto.IngredientUpdateRequestDTO;
import com.wellness360.nutrition.app.recipe.media.dtos.MediaUpdateRequestDTO;
import com.wellness360.nutrition.app.recipe.section.dtos.SectionUpdateRequestDTO;
import com.wellness360.nutrition.packages.crud.dtos.CrudUpdateRequestDTO;
import com.wellness360.nutrition.validation.Validator;

public record RecipeUpdateRequestDTO(
  String uuid,
  String name,
  String description,
  String user_uuid,
  String tag_uuid,
  String category_uuid,
  List<MediaUpdateRequestDTO> media,
  List<IngredientUpdateRequestDTO> ingredients,
  List<SectionUpdateRequestDTO> sections
) implements CrudUpdateRequestDTO {

  public void validate(Validator validator) {
    validator.string.validateName(name, true);
    validator.string.validateText(description, true);
    validator.string.validateUuid(user_uuid, true);
    validator.string.validateUuid(tag_uuid, true);
    validator.string.validateUuid(category_uuid, true);
    if(media != null) media.forEach(image -> validator.media.validateImage(image.getMedia()));
    if(ingredients != null) ingredients.forEach(ingredient -> ingredient.validate(validator));
    if(sections != null) sections.forEach(sections -> sections.validate(validator));
  }

}
