package com.wellness360.nutrition.app.selectivity.dtos;

import com.wellness360.nutrition.packages.crud.dtos.CrudCreateRequestDTO;
import com.wellness360.nutrition.validation.Validator;

public record SelectivityCreateRequestDTO(
  String user_uuid,
  String recipe_uuid,
  String food_uuid,
  String category_uuid
) implements CrudCreateRequestDTO{

  public void validate(Validator validator) {
    validator.string.validateUuid(user_uuid);
    validator.string.validateUuid(recipe_uuid, true);
    validator.string.validateUuid(food_uuid, true);
    validator.string.validateUuid(category_uuid, true);

    String[] uuids = {user_uuid, recipe_uuid, category_uuid};
    validator.array.validateAllNotNull(uuids);
  }

}

