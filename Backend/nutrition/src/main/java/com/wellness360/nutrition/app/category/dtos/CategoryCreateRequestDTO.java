package com.wellness360.nutrition.app.category.dtos;

import org.springframework.web.multipart.MultipartFile;

import com.wellness360.nutrition.packages.storage.dtos.CrudStorageCreateRequestDTO;
import com.wellness360.nutrition.validation.Validator;

public record CategoryCreateRequestDTO(
  String name,
  String description,
  MultipartFile file
) implements CrudStorageCreateRequestDTO {

  public void validate(Validator validator) {
    validator.string.validateName(name);
    validator.string.validateText(description, true);
    validator.media.validateImage(file);
  }

}
