package com.wellness360.nutrition.app.logs.dtos;

import java.time.LocalDate;

import com.wellness360.nutrition.common.dtos.UpdateRequestDTO;
import com.wellness360.nutrition.common.services.ValidateService;

import jakarta.annotation.Nonnull;
import lombok.Getter;

@Getter
public class LogUpdateRequestDTO implements UpdateRequestDTO {
  @Nonnull
  String uuid;
  @Nonnull
  LocalDate date;
  @Nonnull
  Short amount;
  @Nonnull
  String recipe_uuid;
  @Nonnull
  String user_uuid;

  public void validate(ValidateService validator) {
    validator.validateLogDate(date, true);
    validator.validateAmount(amount, true);
    validator.validateUuid(recipe_uuid, true);
    validator.validateUuid(user_uuid, true);
  }
}
