package com.wellness360.nutrition.app.tag.dtos;

import org.springframework.web.multipart.MultipartFile;

import com.wellness360.nutrition.packages.storage.dtos.CrudStorageUpdateRequestDTO;
import com.wellness360.nutrition.validation.Validator;

public record TagUpdateRequestDTO(
  String uuid,
  String name, 
  String description,
  MultipartFile file,
  String category_uuid
) implements CrudStorageUpdateRequestDTO{

  public void validate(Validator validator) {
    validator.string.validateName(name, true);
    validator.string.validateText(description, true);
    validator.media.validateImage(file, true);
    validator.string.validateUuid(category_uuid, true);
  }

}