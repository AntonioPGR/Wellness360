package com.wellness360.nutrition.app.food.dtos;

import org.springframework.web.multipart.MultipartFile;

import com.wellness360.nutrition.common.dtos.UpdateRequestDTO;
import com.wellness360.nutrition.common.services.ValidateService;

import io.micrometer.common.lang.Nullable;
import jakarta.annotation.Nonnull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter(value = AccessLevel.PUBLIC)
public class FoodUpdateRequestDTO implements UpdateRequestDTO{
  @Nonnull
  String uuid;
  @Nullable
  String name;
  @Nullable
  String description;
  @Nullable
  Float carbs;
  @Nullable
  Float proteins;
  @Nullable
  Float fats;
  @Nullable
  Float saturated_fats;
  @Nullable
  Float sodium;
  @Nullable
  Float dietary_fiber;
  @Nullable
  Short serving_amount;
  @Nullable
  MultipartFile image;
  @Nullable
  String tag_uuid;
  @Nullable
  String category_uuid;

  public void validate(ValidateService validator) {
    validator.validateName(name, true);
    validator.validateText(description);
    validator.validateNutrient(carbs, true);
    validator.validateNutrient(proteins, true);
    validator.validateNutrient(fats, true);
    validator.validateNutrient(saturated_fats, true);
    validator.validateNutrient(sodium, true);
    validator.validateNutrient(dietary_fiber, true);
    validator.validateAmount(serving_amount, true);
    validator.validateImage(image, true);
    validator.validateUuid(tag_uuid, true);
    validator.validateUuid(category_uuid, true);
  }

}
