package com.wellness360.exercises.app.trains.sets.dtos;

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
public class SetCreateRequestDTO implements ValidatableDTO {
  
  Integer weight;
  Integer reps;
  Integer minutes;

  public void validate(ValidateService validator) {
    validator.validateShort(weight);
    validator.validateShort(reps);
    validator.validateShort(minutes);
  }

}
