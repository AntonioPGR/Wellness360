package com.wellness360.exercises.crud.dtos;

import com.wellness360.exercises.validation.ValidateService;

public abstract interface ValidatableDTO {
  
  public abstract void validate(ValidateService validator);

}
