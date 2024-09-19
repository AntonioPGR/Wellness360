package com.wellness360.nutrition.packages.validation.validators;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wellness360.nutrition.packages.validation.ErrorsThrower;
import com.wellness360.nutrition.packages.validation.ValidationServiceBase;
import com.wellness360.nutrition.packages.validation.ValidationUtils;

@Service
public class DateValidator extends ValidationServiceBase {
  
  @Autowired
  ValidationUtils utils;

  public void validatePresentOrFutureDate(Date date) {
    validatePresentOrFutureDate(date, false);
  }
  public void validatePresentOrFutureDate(Date date, boolean nullable) {
    String label = "Date";
    if(utils.isNullableAndNull(nullable, date)) return;
    validateNotNull(date, label);
    if(date.before(new Date())) ErrorsThrower.validationError(label + " can't be in the past");
  }


  public void validatePastDate(Date date) {
    validatePastDate(date, false);
  }
  public void validatePastDate(Date date, boolean nullable) {
    String label = "Date";
    if(utils.isNullableAndNull(nullable, date)) return;
    validateNotNull(date, label);
    if(date.after(new Date())) ErrorsThrower.validationError(label + " can't be in the future");
  }


  public void validatePastOrPresentDate(Date date) {
    validatePastOrPresentDate(date, false);
  }
  public void validatePastOrPresentDate(Date date, boolean nullable) {
    String label = "Date";
    if(utils.isNullableAndNull(nullable, date)) return;
    validateNotNull(date, label);
    if(date.after(new Date())) ErrorsThrower.validationError(label + " can't be in the future");
  }

}
