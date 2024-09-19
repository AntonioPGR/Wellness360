package com.wellness360.nutrition.packages.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wellness360.nutrition.packages.validation.validators.ArrayValidator;
import com.wellness360.nutrition.packages.validation.validators.DateValidator;
import com.wellness360.nutrition.packages.validation.validators.MediaValidator;
import com.wellness360.nutrition.packages.validation.validators.NumberValidator;
import com.wellness360.nutrition.packages.validation.validators.StringValidator;

@Service
public class ValidationService extends ValidationServiceBase {

  @Autowired
  public StringValidator string;

  @Autowired
  public DateValidator date;

  @Autowired
  public MediaValidator media;

  @Autowired
  public NumberValidator number;

  @Autowired
  public ArrayValidator array;

}
