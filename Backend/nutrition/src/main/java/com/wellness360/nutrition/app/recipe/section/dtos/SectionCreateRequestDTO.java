package com.wellness360.nutrition.app.recipe.section.dtos;

import com.wellness360.nutrition.packages.crud.dtos.CrudCreateRequestDTO;
import com.wellness360.nutrition.validation.Validator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SectionCreateRequestDTO implements CrudCreateRequestDTO {
    
  private String text;
  private String included_recipe_uuid;

  public void validate(Validator validator) {
    validator.string.validateText(text);
    validator.string.validateUuid(included_recipe_uuid, true);
  }
}
