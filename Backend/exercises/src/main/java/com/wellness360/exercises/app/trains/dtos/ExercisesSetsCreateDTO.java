package com.wellness360.exercises.app.trains.dtos;

import java.util.List;

import com.wellness360.exercises.app.trains.sets.dtos.SetCreateRequestDTO;
import com.wellness360.exercises.packages.crud.dtos.interfaces.ValidatableDTO;
import com.wellness360.exercises.packages.validation.ValidateService;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ExercisesSetsCreateDTO implements ValidatableDTO {

  String exercise_uuid;
  List<SetCreateRequestDTO> sets;

  public void validate(ValidateService validator) {
    validator.validateUuid(exercise_uuid);
    sets.forEach(dto -> dto.validate(validator));
  }
  
}
