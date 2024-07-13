package com.wellness360.exercises.app.trains.dtos;

import java.util.List;

import com.wellness360.exercises.packages.crud.dtos.CrudCreateRequestDTO;
import com.wellness360.exercises.packages.validation.ValidateService;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TrainCreateRequestDTO extends CrudCreateRequestDTO{

  String user_uuid;
  Integer week_day;
  String name;
  String description;
  List<ExercisesSetsCreateDTO> exercise_sets;

  public void validate(ValidateService validator) {
    validator.validateUuid(user_uuid);
    validator.validateShort(week_day);
    validator.validateName(name);
    validator.validateDescription(description, true);
    exercise_sets.forEach(dto -> dto.validate(validator));
  }

}
