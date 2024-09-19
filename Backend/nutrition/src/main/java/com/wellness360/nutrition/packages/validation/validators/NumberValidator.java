package com.wellness360.nutrition.packages.validation.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wellness360.nutrition.packages.validation.ErrorsThrower;
import com.wellness360.nutrition.packages.validation.ValidationServiceBase;
import com.wellness360.nutrition.packages.validation.ValidationUtils;

@Service
public class NumberValidator extends ValidationServiceBase {
  
  @Autowired
  ValidationUtils utils;

  public void validateBoolean(int bool){
    validateBoolean(bool, false);
  }
  public void validateBoolean(int bool, boolean nullable){
    String label = "Boolean";
    if(utils.isNullableAndNull(nullable, bool)) return;
    validateNotNull(bool, label);
    if(utils.isBoolean(bool)) ErrorsThrower.validationError(label + " must be 0 or 1");
  }

  public void validateShort(Integer number) {
    validateShort(number, false);
  }
  public void validateShort(Integer number, boolean nullable) {
    String label = "Short"; 
    if(utils.isNullableAndNull(nullable, number)) return;
    validateNotNull(number, label);
    if(number >= 32767) ErrorsThrower.validationError(label + "s values can't be more than 32.766");
  }

}
