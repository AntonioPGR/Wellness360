package com.wellness360.nutrition.app.category.dtos;

import org.springframework.web.multipart.MultipartFile;

import com.wellness360.nutrition.common.dtos.ValidatableDTO;
import com.wellness360.nutrition.common.services.ValidateService;

import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryCreateRequestDTO implements ValidatableDTO {
  @Nonnull
  protected String name;
  @Nullable
  protected String description;
  @Nonnull
  protected MultipartFile image;

  public void validate(ValidateService validator) {
    validator.validateName(name);
    validator.validateText(description);
    validator.validateImage(image);
  }

}
