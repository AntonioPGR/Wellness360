package com.wellness360.nutrition.app.recipe.ingredient.dto;

import com.wellness360.nutrition.packages.crud.dtos.CrudUpdateRequestDTO;
import com.wellness360.nutrition.validation.Validator;

public record IngredientUpdateRequestDTO(
  String uuid,
  String food_uuid,
  Short amount
) implements CrudUpdateRequestDTO {

  public void validate(Validator validator) {
    validator.string.validateUuid(uuid);
    validator.string.validateUuid(food_uuid, true);
    validator.validateAmount(amount, true);
  }

}
