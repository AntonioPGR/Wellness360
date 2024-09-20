package com.wellness360.nutrition.app.logs.dtos;

import java.util.Date;
import com.wellness360.nutrition.packages.crud.dtos.CrudCreateRequestDTO;
import com.wellness360.nutrition.validation.Validator;

public record LogCreateRequestDTO(
  Date date,
  Short amount,
  String recipe_uuid,
  String user_uuid
) implements CrudCreateRequestDTO {

  public void validate(Validator validator) {
    validator.date.validatePastOrPresentDate(date);
    validator.validateAmount(amount);
    validator.string.validateUuid(recipe_uuid);
    validator.string.validateUuid(user_uuid);
  }

}
