package com.wellness360.community.packages.crud.dtos.interfaces;

import com.wellness360.community.packages.validation.ValidateService;

public abstract interface ValidatableDTO {
  
  public abstract void validate(ValidateService validator);

}
