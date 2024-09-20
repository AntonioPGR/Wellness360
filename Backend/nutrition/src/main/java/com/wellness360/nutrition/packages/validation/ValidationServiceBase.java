package com.wellness360.nutrition.packages.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ValidationServiceBase {

  @Autowired
  public ValidationUtils utils;

  @Autowired
  public ValidationProperties properties;

  public void validateNotNull(Object obj, String label){
    if(utils.isNull(obj)) ErrorsThrower.cantBeNull(label);
  }

  public void validateNotEmpty(String obj, String label){
    if(utils.isEmpty(obj)) ErrorsThrower.cantBeEmpty(label);
  }

}
