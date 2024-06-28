package com.wellness360.exercises.app.exercises.equipments.dtos;

import org.springframework.web.multipart.MultipartFile;

import com.wellness360.exercises.packages.storage.dtos.CrudStorageCreateRequestDTO;
import com.wellness360.exercises.packages.validation.ValidateService;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EquipmentCreateRequestDTO extends CrudStorageCreateRequestDTO {
  
  String name;
  String description;
  MultipartFile file;

  public void validate(ValidateService validator) {
    validator.validateName(name);
    validator.validateDescription(description, true);
    validator.validateImage(file);
  }

}
