package com.wellness360.exercises.app.exercises.dtos;

import java.util.List;

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
public class ExerciseCreateRequestDTO extends CrudStorageCreateRequestDTO {
  
  String name;
  String description;
  MultipartFile file;
  String category;
  MultipartFile video;
  List<String> muscles;
  List<String> equipments_uuid;

  public void validate(ValidateService validator) {
    validator.validateName(name);
    validator.validateDescription(description, true);
    validator.validateImage(file);
    validator.validateExerciseCategory(category);
    validator.validateVideo(video);
    muscles.stream().forEach(muscle -> validator.validateBodyMuscle(muscle));
    equipments_uuid.stream().forEach(uuid -> validator.validateUuid(uuid));
  }

}
