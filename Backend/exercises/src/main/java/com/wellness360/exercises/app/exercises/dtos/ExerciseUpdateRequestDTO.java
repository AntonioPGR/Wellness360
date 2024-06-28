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
    validator.validateUuid(uuid);
    validator.validateName(name, true);
    validator.validateDescription(description, true);
    validator.validateImage(file, true);
    validator.validateExerciseCategory(category, true);
    validator.validateVideo(video, true);
    if(muscles != null) muscles.stream().forEach(muscle -> validator.validateBodyMuscle(muscle));
    if(equipments_uuid != null) equipments_uuid.stream().forEach(uuid -> validator.validateUuid(uuid));
  }

}
