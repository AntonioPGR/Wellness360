package com.wellness360.exercises.app.exercises.dtos;

import java.util.List;

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
public class ExerciseUpdateRequestDTO extends CrudStorageUpdateRequestDTO {
  
  String uuid;
  String name;
  String description;
  MultipartFile file;
  String category;
  MultipartFile video;
  List<String> muscles;
  List<String> equipments_uuid;

  public void validate(ValidateService validator) {
    throw new UnsupportedOperationException("Unimplemented method 'validate'");
  }

}
