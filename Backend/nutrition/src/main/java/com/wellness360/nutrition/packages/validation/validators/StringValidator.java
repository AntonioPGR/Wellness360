package com.wellness360.nutrition.packages.validation.validators;

import org.springframework.stereotype.Service;

import com.wellness360.nutrition.packages.validation.ErrorsThrower;
import com.wellness360.nutrition.packages.validation.ValidationServiceBase;

@Service
public class StringValidator extends ValidationServiceBase{
  
  public void validateUuid(String uuid) {
    validateUuid(uuid, false);
  }
  public void validateUuid(String uuid, boolean nullable) {
    String label = "Uuid";
    if(utils.isNullableAndNull(nullable, uuid)) return;
    validateNotNull(uuid, label);
    validateNotEmpty(uuid, label);
    if(utils.isLengthDifferentFrom(uuid, 36)) ErrorsThrower.validationError(label + " must have exactly 36 characters");
    if(!utils.isUuidValid(uuid)) ErrorsThrower.validationError(label + " format is invalid");
  }

  public void validateName(String name){
    validateName(name, false);
  }
  public void validateName(String name, Boolean nullable) {
    String label = "Name";
    if(utils.isNullableAndNull(nullable, name)) return;
    validateNotNull(name, label);
    validateNotEmpty(name, label);

    if(utils.hasSymbols(name)) ErrorsThrower.validationError(label + " cannot have symbols");
    if(utils.hasNumbers(name)) ErrorsThrower.validationError(label + " cannot have numbers");
    if(utils.isLengthGreaterThan(name, properties.getMax_name_lenght())) ErrorsThrower.maxCharactersExceeded(label, properties.getMax_name_lenght());
  }

  public void validateText(String text) {
    validateText(text, false);
  }
  public void validateText(String text, boolean nullable) {
    String label = "Text";
    if(utils.isNullableAndNull(nullable, text)) return;
    validateNotNull(text, label);
    if(utils.isLengthGreaterThan(text, properties.getMax_text_lenght())) ErrorsThrower.maxCharactersExceeded(label, properties.getMax_text_lenght());
  }

  public void validateRegex(String string, String pattern){
    if(!string.matches(pattern)) ErrorsThrower.validationError("Should match " + pattern + " regex pattern");
  }

  public void validateUsername(String username) {
    validateUsername(username, false);
  }
  public void validateUsername(String username, boolean nullable) {
    String label = "Username";
    if(utils.isNullableAndNull(nullable, username)) return;
    validateNotNull(username, label);
    validateNotEmpty(username, label);

    if(utils.hasSymbols(username)) ErrorsThrower.validationError(label + " cannot have symbols");
    if(utils.isLengthGreaterThan(username, properties.getMax_name_lenght())) ErrorsThrower.maxCharactersExceeded(label, properties.getMax_name_lenght());
  }

}
