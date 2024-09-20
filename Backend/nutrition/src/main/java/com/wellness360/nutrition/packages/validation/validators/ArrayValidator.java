package com.wellness360.nutrition.packages.validation.validators;

import org.springframework.stereotype.Service;

import jakarta.validation.ValidationException;

@Service
public class ArrayValidator {
  
  public void validateAllNotNull(Object[] objs){
    int non_null = 0;
    for(Object obj : objs){
      if(obj != null){
        return;
      }
    }
    if(non_null == 0) throw new ValidationException("One of the objects passed must not be null");
  }
  
}
