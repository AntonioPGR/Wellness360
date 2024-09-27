package com.wellness360.nutrition.app.food.dtos;

import org.springframework.web.multipart.MultipartFile;

import com.wellness360.nutrition.packages.storage.dtos.CrudStorageCreateRequestDTO;
import com.wellness360.nutrition.validation.Validator;

public record FoodCreateRequestDTO(
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
  String category_uuid
) implements CrudStorageCreateRequestDTO{

  public void validate(Validator validator) {
    validator.string.validateName(name);
    validator.string.validateText(description, true);
    validator.string.validateUuid(category_uuid, true);
    validator.media.validateImage(file);
    validator.validateNutrient(carbs);
    validator.validateNutrient(proteins);
    validator.validateNutrient(fats);
    validator.validateNutrient(saturated_fats);
    validator.validateNutrient(sodium);
    validator.validateNutrient(dietary_fiber);
    validator.validateAmount(serving_amount);
  }

}
