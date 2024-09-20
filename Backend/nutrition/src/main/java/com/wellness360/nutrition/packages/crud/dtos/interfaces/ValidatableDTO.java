package com.wellness360.nutrition.packages.crud.dtos.interfaces;

import com.wellness360.nutrition.validation.Validator;

public abstract interface ValidatableDTO {
  
  public abstract void validate(Validator validator);

}
