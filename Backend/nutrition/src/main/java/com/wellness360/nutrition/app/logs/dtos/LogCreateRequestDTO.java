package com.wellness360.nutrition.app.logs.dtos;

import java.time.LocalDate;

import com.wellness360.nutrition.common.dtos.ValidatableDTO;
import com.wellness360.nutrition.common.services.ValidateService;

import jakarta.annotation.Nonnull;
import lombok.Getter;

@Getter
public class LogCreateRequestDTO implements ValidatableDTO {
  @Nonnull
  LocalDate date;
  @Nonnull
  Short amount;
  @Nonnull
  String recipe_uuid;
  @Nonnull
  String user_uuid;

  public void validate(ValidateService validator) {
    validator.validateLogDate(date);
    validator.validateAmount(amount);
    validator.validateUuid(recipe_uuid);
    validator.validateUuid(user_uuid);
  }

}
