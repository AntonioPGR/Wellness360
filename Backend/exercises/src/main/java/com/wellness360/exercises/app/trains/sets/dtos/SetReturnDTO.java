package com.wellness360.exercises.app.trains.sets.dtos;

import com.wellness360.exercises.app.trains.sets.SetEntity;
import com.wellness360.exercises.packages.crud.dtos.interfaces.ValidatableDTO;
import com.wellness360.exercises.packages.validation.ValidateService;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class SetReturnDTO implements ValidatableDTO {
  
  String uuid;
  Integer weight;
  Integer reps;
  Integer minutes;

  public void validate(ValidateService validator) {
    throw new UnsupportedOperationException("Unimplemented method 'validate'");
  }

  public SetReturnDTO(SetEntity set) {
    uuid = set.getUuid();
    weight = set.getWeight().intValue();
    reps = set.getReps().intValue();
    minutes = set.getMinutes().intValue();
  }

}
