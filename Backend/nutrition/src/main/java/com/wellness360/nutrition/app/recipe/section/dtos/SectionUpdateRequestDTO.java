package com.wellness360.nutrition.app.recipe.section.dtos;

import com.wellness360.nutrition.common.dtos.UpdateRequestDTO;
import com.wellness360.nutrition.common.services.ValidateService;

import io.micrometer.common.lang.Nullable;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
public class SectionUpdateRequestDTO implements UpdateRequestDTO {
  @NonNull
  String uuid;
  @Nullable
  String text;
  @Nullable
  String included_recipe_uuid;

  public void validate(ValidateService validator) {
    validator.validateText(text);
    validator.validateUuid(included_recipe_uuid, true);
  }

}
