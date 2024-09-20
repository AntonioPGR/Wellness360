package com.wellness360.users.validation;


import java.sql.Date;

import org.springframework.stereotype.Service;

import com.wellness360.users.packages.validation.ErrorsThrower;
import com.wellness360.users.packages.validation.ValidationService;

@Service
public class Validator extends ValidationService {

  public void validateEmail(String email) {
    validateEmail(email, false);
  }
  public void validateEmail(String email, boolean nullable) {
    String label = "Email";
    if(utils.isNullableAndNull(nullable, email)) return;
    validateNotNull(email, label);
    string.validateRegex(email, "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$");
  }

  public void validatePassword(String password) {
    validatePassword(password, false);
  }
  public void validatePassword(String password, boolean nullable) {
    String label = "Password";
    if(utils.isNullableAndNull(nullable, password)) return;
    validateNotNull(password, label);
    string.validateRegex(password, "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[@#$%^&+=]).{8,}$");
  }

  public void validateGender(char gender) {
    validateGender(gender, false);
  }
  public void validateGender(char gender, boolean nullable) {
    String label = "Gender";
    if(gender <= 32 && nullable) return;
    validateNotNull(gender, label);
    gender = Character.toUpperCase(gender);
    if(gender != 'M' && gender != 'F' && gender != 'N') ErrorsThrower.validationError(label + " must be M, F or N");
  }

  public void validateBirthDate(Date birth) {
    validateBirthDate(birth, false);
  }
  public void validateBirthDate(Date birth, boolean nullable) {
    date.validatePastDate(birth, nullable);
  }

  public void validateHeight(int height) {
    validateHeight(height, false);
  }
  public void validateHeight(int height, boolean nullable) {
    number.validateShort(height, nullable);
  }
  
}
