package com.wellness360.nutrition.app.category.dtos;

import org.springframework.web.multipart.MultipartFile;

import com.wellness360.nutrition.packages.storage.dtos.CrudStorageUpdateRequestDTO;
import com.wellness360.nutrition.validation.Validator;

public record CategoryUpdateRequestDTO(
  String uuid,
  String name,
  String description,
  MultipartFile file
) implements CrudStorageUpdateRequestDTO {

  public void validate(Validator validator) {
    validator.string.validateUuid(uuid);
    validator.string.validateName(name, true);
    validator.string.validateText(description, true);
    validator.media.validateImage(file, true);
  }

}
