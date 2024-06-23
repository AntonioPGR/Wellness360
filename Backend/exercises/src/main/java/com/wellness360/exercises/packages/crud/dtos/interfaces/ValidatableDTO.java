package com.wellness360.exercises.packages.crud.dtos.interfaces;

import com.wellness360.exercises.packages.validation.ValidateService;

public abstract interface ValidatableDTO {
  
  public abstract void validate(ValidateService validator);

}
