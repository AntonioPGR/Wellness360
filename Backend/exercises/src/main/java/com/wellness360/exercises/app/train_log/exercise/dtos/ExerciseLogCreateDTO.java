package com.wellness360.exercises.app.train_log.exercise.dtos;

import java.util.List;

import com.wellness360.exercises.app.train_log.sets.dtos.SetLogCreateDTO;
import com.wellness360.exercises.packages.crud.dtos.interfaces.ValidatableDTO;
import com.wellness360.exercises.packages.validation.ValidateService;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ExerciseLogCreateDTO implements ValidatableDTO {

  String exercise_uuid;
  List<SetLogCreateDTO> sets;

  public void validate(ValidateService validator) {
    validator.validateUuid(exercise_uuid);
    sets.forEach(set -> set.validate(validator));
  }

}
