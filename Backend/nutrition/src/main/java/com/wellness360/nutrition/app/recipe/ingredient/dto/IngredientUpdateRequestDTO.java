package com.wellness360.nutrition.app.recipe.ingredient.dto;

import com.wellness360.nutrition.common.dtos.UpdateRequestDTO;
import com.wellness360.nutrition.common.services.ValidateService;

import io.micrometer.common.lang.Nullable;
import jakarta.annotation.Nonnull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IngredientUpdateRequestDTO implements UpdateRequestDTO {
  @Nonnull
  String uuid;
  @Nullable
  String food_uuid;
  @Nullable
  Short amount;

  public void validate(ValidateService validator) {
    validator.validateUuid(uuid);
    validator.validateUuid(food_uuid, true);
    validator.validateAmount(amount, true);
  }

}
