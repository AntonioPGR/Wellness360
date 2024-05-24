package com.wellness360.nutrition.app.tag.dtos;

import org.springframework.web.multipart.MultipartFile;

import com.wellness360.nutrition.common.dtos.UpdateRequestDTO;
import com.wellness360.nutrition.common.services.ValidateService;

import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TagUpdateRequestDTO implements UpdateRequestDTO{
  @Nonnull
  String uuid;
  @Nullable
  String name; 
  @Nullable
  String description;
  @Nullable
  MultipartFile image;
  @Nullable
  String category_uuid;

  public void validate(ValidateService validator) {
    validator.validateName(name, true);
    validator.validateText(description);
    validator.validateImage(image, true);
    validator.validateUuid(category_uuid, true);
  }

}