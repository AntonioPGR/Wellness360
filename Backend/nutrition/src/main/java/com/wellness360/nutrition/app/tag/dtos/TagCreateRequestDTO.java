package com.wellness360.nutrition.app.tag.dtos;

import org.springframework.web.multipart.MultipartFile;

import com.wellness360.nutrition.common.dtos.ValidatableDTO;
import com.wellness360.nutrition.common.services.ValidateService;

import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TagCreateRequestDTO implements ValidatableDTO{
  @Nonnull
  String name; 
  @Nullable
  String description;
  @Nonnull
  MultipartFile image;
  @Nonnull
  String category_uuid;

  public void validate(ValidateService validator) {
    validator.validateName(name);
    validator.validateText(description);
    validator.validateImage(image);
    validator.validateUuid(category_uuid);
  }
}

