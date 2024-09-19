package com.wellness360.nutrition.app.logs.dtos;

import java.util.Date;

import com.wellness360.nutrition.packages.crud.dtos.CrudUpdateRequestDTO;
import com.wellness360.nutrition.validation.Validator;

public record LogUpdateRequestDTO(
  String uuid,
  Date date,
  Short amount,
  String recipe_uuid,
  String user_uuid
) implements CrudUpdateRequestDTO {

  public void validate(Validator validator) {
    validator.date.validatePastOrPresentDate(date, true);
    validator.validateAmount(amount, true);
    validator.string.validateUuid(recipe_uuid, true);
    validator.string.validateUuid(user_uuid, true);
  }

}
