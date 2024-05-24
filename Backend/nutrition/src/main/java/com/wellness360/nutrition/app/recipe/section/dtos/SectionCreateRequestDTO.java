package com.wellness360.nutrition.app.recipe.section.dtos;

import com.wellness360.nutrition.common.dtos.ValidatableDTO;
import com.wellness360.nutrition.common.services.ValidateService;

import io.micrometer.common.lang.Nullable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SectionCreateRequestDTO implements ValidatableDTO {
  @Nullable
  String text;
  @Nullable
  String included_recipe_uuid;

  public void validate(ValidateService validator) {
    validator.validateText(text);
    validator.validateUuid(included_recipe_uuid);
  }
  
}
