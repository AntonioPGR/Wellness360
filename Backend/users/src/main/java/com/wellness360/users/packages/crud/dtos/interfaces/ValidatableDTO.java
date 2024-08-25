package com.wellness360.users.packages.crud.dtos.interfaces;

import com.wellness360.users.validation.Validator;

public abstract interface ValidatableDTO {
  
  public abstract void validate(Validator validator);

}
