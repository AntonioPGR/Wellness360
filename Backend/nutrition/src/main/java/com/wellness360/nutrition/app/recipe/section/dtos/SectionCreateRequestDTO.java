package com.wellness360.nutrition.app.recipe.section.dtos;

import com.wellness360.nutrition.packages.crud.dtos.CrudCreateRequestDTO;
import com.wellness360.nutrition.validation.Validator;

public record SectionCreateRequestDTO(
  String text,
  String included_recipe_uuid
) implements CrudCreateRequestDTO {

  public void validate(Validator validator) {
    validator.string.validateText(text);
    validator.string.validateUuid(included_recipe_uuid);
  }
  
}
