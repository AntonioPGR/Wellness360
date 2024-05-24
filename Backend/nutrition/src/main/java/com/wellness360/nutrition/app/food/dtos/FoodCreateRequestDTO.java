package com.wellness360.nutrition.app.food.dtos;

import org.springframework.web.multipart.MultipartFile;

import com.wellness360.nutrition.common.dtos.ValidatableDTO;
import com.wellness360.nutrition.common.services.ValidateService;

import io.micrometer.common.lang.Nullable;
import jakarta.annotation.Nonnull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter(value = AccessLevel.PUBLIC)
public class FoodCreateRequestDTO implements ValidatableDTO{
  @Nonnull
  String name;
  @Nullable
  String description;
  @Nonnull
  Float carbs;
  @Nonnull
  Float proteins;
  @Nonnull
  Float fats;
  @Nonnull
  Float saturated_fats;
  @Nonnull
  Float sodium;
  @Nonnull
  Float dietary_fiber;
  @Nonnull
  Short serving_amount;
  @Nonnull
  MultipartFile image;
  @Nonnull
  String tag_uuid;
  @Nonnull
  String category_uuid;

  public void validate(ValidateService validator) {
    validator.validateName(name);
    validator.validateText(description);
    validator.validateNutrient(carbs);
    validator.validateNutrient(proteins);
    validator.validateNutrient(fats);
    validator.validateNutrient(saturated_fats);
    validator.validateNutrient(sodium);
    validator.validateNutrient(dietary_fiber);
    validator.validateAmount(serving_amount);
    validator.validateImage(image);
    validator.validateUuid(tag_uuid);
    validator.validateUuid(category_uuid);
  }

}
