package com.wellness360.exercises.app.train_log.sets.dtos;

import com.wellness360.exercises.packages.validation.ValidateService;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SetLogCreateDTO {

  String uuid;
  Integer weight;
  Integer reps;
  Integer minutes;

  public void validate(ValidateService validator) {
    validator.validateUuid(uuid);
    validator.validateShort(minutes, true);
    validator.validateShort(weight, true);
    validator.validateShort(reps, true);
  }

}
