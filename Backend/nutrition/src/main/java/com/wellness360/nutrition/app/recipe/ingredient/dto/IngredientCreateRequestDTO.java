package com.wellness360.nutrition.app.recipe.ingredient.dto;

import com.wellness360.nutrition.common.dtos.ValidatableDTO;
import com.wellness360.nutrition.common.services.ValidateService;

import jakarta.annotation.Nonnull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IngredientCreateRequestDTO implements ValidatableDTO {
  @Nonnull
  String food_uuid;
  @Nonnull
  String amount;

  public void validate(ValidateService validator) {
    validator.validateUuid(food_uuid);
    validator.validateAmount((short) Integer.parseUnsignedInt(amount));
  }
}
