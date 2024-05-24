package com.wellness360.nutrition.common.dtos;

import com.wellness360.nutrition.common.services.ValidateService;

public abstract interface ValidatableDTO {
  
  public abstract void validate(ValidateService validator);

}
