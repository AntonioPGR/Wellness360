package com.wellness360.nutrition.app.category.dtos;

import org.springframework.web.multipart.MultipartFile;

import com.wellness360.nutrition.common.dtos.UpdateRequestDTO;
import com.wellness360.nutrition.common.services.ValidateService;

import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryUpdateRequestDTO implements UpdateRequestDTO {
  @Nonnull
  protected String uuid;
  @Nullable
  protected String name;
  @Nullable
  protected String description;
  @Nullable
  protected MultipartFile image;

  @Override
  public void validate(ValidateService validator) {
    validator.validateUuid(uuid);
    validator.validateName(name, true);
    validator.validateText(description);
    validator.validateImage(image, true);
  }

}
