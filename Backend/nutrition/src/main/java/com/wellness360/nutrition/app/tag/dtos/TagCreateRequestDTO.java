package com.wellness360.nutrition.app.tag.dtos;

import org.springframework.web.multipart.MultipartFile;

import com.wellness360.nutrition.packages.storage.dtos.CrudStorageCreateRequestDTO;
import com.wellness360.nutrition.validation.Validator;

public record TagCreateRequestDTO(
  String name,
  String description,
  MultipartFile file,
  String category_uuid
) implements CrudStorageCreateRequestDTO{

  public void validate(Validator validator) {
    validator.string.validateName(name);
    validator.string.validateText(description, true);
    validator.media.validateImage(file);
    validator.string.validateUuid(category_uuid);
  }
}

