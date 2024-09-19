package com.wellness360.users.packages.crud.dtos.interfaces;

import com.wellness360.users.packages.validation.ValidateService;

public abstract interface ValidatableDTO {
  
  public abstract void validate(ValidateService validator);

}
