package com.wellness360.nutrition.app.food.dtos;

import org.springframework.web.multipart.MultipartFile;

import com.wellness360.nutrition.packages.storage.dtos.CrudStorageUpdateRequestDTO;
import com.wellness360.nutrition.validation.Validator;

public record FoodUpdateRequestDTO(
  String uuid,
  String name,
  String description,
  Float carbs,
  Float proteins,
  Float fats,
  Float saturated_fats,
  Float sodium,
  Float dietary_fiber,
  Short serving_amount,
  MultipartFile file,
  String tag_uuid,
  String category_uuid
) implements CrudStorageUpdateRequestDTO{

  public void validate(Validator validator) {
    validator.string.validateUuid(uuid, false);
    validator.string.validateUuid(tag_uuid, true);
    validator.string.validateUuid(category_uuid, true);
    validator.string.validateName(name, true);
    validator.string.validateText(description, true);
    validator.media.validateImage(file, true);
    validator.validateNutrient(carbs, true);
    validator.validateNutrient(proteins, true);
    validator.validateNutrient(fats, true);
    validator.validateNutrient(saturated_fats, true);
    validator.validateNutrient(sodium, true);
    validator.validateNutrient(dietary_fiber, true);
    if(carbs!=null || proteins!=null || fats!=null || saturated_fats!=null || sodium!=null || dietary_fiber!=null) {
      validator.validateAmount(serving_amount);
    } else validator.validateAmount(serving_amount, true);
  }

}
