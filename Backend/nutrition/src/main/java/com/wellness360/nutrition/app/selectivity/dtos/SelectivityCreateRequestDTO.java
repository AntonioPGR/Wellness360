package com.wellness360.nutrition.app.selectivity.dtos;

import com.wellness360.nutrition.common.dtos.ValidatableDTO;
import com.wellness360.nutrition.common.services.ValidateService;

import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import lombok.Getter;


@Getter
public class SelectivityCreateRequestDTO implements ValidatableDTO{
  @Nonnull
  String user_uuid;
  @Nullable
  String recipe_uuid;
  @Nullable
  String food_uuid;
  @Nullable
  String category_uuid;

  public void validate(ValidateService validator) {
    validator.validateUuid(user_uuid, true);
    validator.validateUuid(recipe_uuid, true);
    validator.validateUuid(food_uuid, true);
    validator.validateUuid(category_uuid, true);
  }

}

