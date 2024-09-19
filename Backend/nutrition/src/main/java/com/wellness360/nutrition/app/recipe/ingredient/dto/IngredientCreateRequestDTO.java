package com.wellness360.nutrition.app.recipe.ingredient.dto;

import com.wellness360.nutrition.packages.crud.dtos.CrudCreateRequestDTO;
import com.wellness360.nutrition.validation.Validator;

public record IngredientCreateRequestDTO(
  String food_uuid,
  int amount
) implements CrudCreateRequestDTO {

  public void validate(Validator validator) {
    validator.string.validateUuid(food_uuid);
    validator.number.validateShort(amount);
    validator.validateAmount((short) amount);
  }
}
