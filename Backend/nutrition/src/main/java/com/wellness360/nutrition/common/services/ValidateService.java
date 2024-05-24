package com.wellness360.nutrition.common.services;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.wellness360.nutrition.common.tools.ValidationUtils;
import com.wellness360.nutrition.configurations.ValidationProperties;

import jakarta.validation.ValidationException;

@Service
public class ValidateService {

  @Autowired
  private ValidationUtils validation_utils;
  final ValidationProperties properties;

  public ValidateService(ValidationProperties properties){
    this.properties = properties;
  }


  public void validateName(String name){
    this.validateName(name, false);
  }
  public void validateName(String name, Boolean isNullabe) {
    String label = "Name";
    if(isNullabe && validation_utils.isNull(name)) return;
    if(validation_utils.isNullOrEmpty(name)) throwNotNullError(label);
    if(validation_utils.hasSymbols(name)) throw new ValidationException("Name cannot have symbols");
    if(validation_utils.hasNumbers(name)) throw new ValidationException("Name cannot have numbers");

    Integer max_lenght = properties.getName_lenght();
    if(validation_utils.isLengthGreaterThan(name, max_lenght)) throwCharactersError(label, max_lenght);
  }

  public void validateText(String description) {
    if(validation_utils.isNull(description)) return;
    Integer max_lenght = properties.getText_lenght();
    if(validation_utils.isLengthGreaterThan(description, max_lenght)) throwCharactersError("Description", max_lenght);
  }


  public void validateImage(MultipartFile image){
    this.validateImage(image, false);
  }
  public void validateImage(MultipartFile image, Boolean isNullabe) {
    String label = "Media"; 
    if(isNullabe && validation_utils.isNull(image)) return;
    if(validation_utils.isNull(image)) throwNotNullError(label);
    if(!validation_utils.isImageExtensionSupported(image, properties.getImage_extensions())) throw new ValidationException(label + " unsuported type");
    if(validation_utils.isImageBiggerThanInMb(image, properties.getImage_size())) throw new ValidationException(label + " size is large than allowed");
  }

  public void validateUuid(String uuid) {
    validateUuid(uuid, false);
  }
  public void validateUuid(String uuid, boolean nullable) {
    String label = "Uuid";
    if(nullable == true && validation_utils.isNull(uuid)) return;
    if(validation_utils.isNullOrEmpty(uuid)) throwNotNullError(label);
    if(validation_utils.isLengthDifferentFrom(uuid, 36)) throw new ValidationException(label + " must have exactly 36 characters");
    if(!validation_utils.isUuidValid(uuid)) throw new ValidationException(label + " format is invalid");
  }

  private void throwNotNullError(String label){
    throw new ValidationException(label + " cannot be null");
  }
  private void throwCharactersError(String label, Integer lenght){
    throw new ValidationException(label + " cannot have more than " + lenght + " characters");
  }


  public void validateLogDate(LocalDate date, boolean b) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'validateLogDate'");
  }
  public void validateAmount(Short amount, boolean b) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'validateAmount'");
  }


  public void validateLogDate(LocalDate date) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'validateLogDate'");
  }


  public void validateAmount(Short amount) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'validateAmount'");
  }


  public void validateNutrient(Float carbs) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'validateNutrient'");
  }


  public void validateNutrient(Float carbs, boolean b) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'validateNutrient'");
  }


  

}
