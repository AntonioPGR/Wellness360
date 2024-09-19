package com.wellness360.nutrition.validation;



import org.springframework.stereotype.Service;

import com.wellness360.nutrition.packages.validation.ValidationService;

@Service
public class Validator extends ValidationService {

  public void validateNutrient(Float nutrient) {
    validateNutrient(nutrient, false);
  }
  public void validateNutrient(Float nutrient, boolean nullable) {
    if(utils.isNullableAndNull(nullable, nutrient)) return;
    validateNotNull(nutrient, "Nutrients component");
  }

  public void validateAmount(Short amount) {
    validateAmount(amount, false);
  }
  public void validateAmount(Short amount, boolean nullable) {
    if(utils.isNullableAndNull(nullable, amount)) return;
    validateNotNull(amount, "Amount");
  }

}
