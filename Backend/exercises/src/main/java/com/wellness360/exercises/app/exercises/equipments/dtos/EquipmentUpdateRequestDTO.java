package com.wellness360.exercises.app.exercises.equipments.dtos;

import org.springframework.web.multipart.MultipartFile;

import com.wellness360.exercises.packages.storage.dtos.CrudStorageUpdateRequestDTO;
import com.wellness360.exercises.packages.validation.ValidateService;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EquipmentUpdateRequestDTO extends CrudStorageUpdateRequestDTO {

  String uuid;
  String name;
  String description;
  MultipartFile file;

  public void validate(ValidateService validator) {
    validator.validateUuid(uuid);
    validator.validateName(name, true);
    validator.validateDescription(description, true);
    validator.validateImage(file, true);
  }

}
