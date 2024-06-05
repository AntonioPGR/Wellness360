package com.wellness360.exercises.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ValidateService {

  @Autowired
  private ValidationUtils utils;
  
  final ValidationProperties properties;
  public ValidateService(ValidationProperties properties){
    this.properties = properties;
  }


  // NAME
  public void validateName(String name){
    this.validateName(name, false);
  }
  public void validateName(String name, Boolean isNullabe) {
    String label = "Name";
    if(isNullabe && utils.isNull(name)) return;
    if(utils.isNullOrEmpty(name)) ErrorsThrower.cantBeNull(label);
    if(utils.hasSymbols(name)) ErrorsThrower.validationError(label + " cannot have symbols");
    if(utils.hasNumbers(name)) ErrorsThrower.validationError(label + " cannot have numbers");

    Integer max_lenght = properties.getName_lenght();
    if(utils.isLengthGreaterThan(name, max_lenght)) ErrorsThrower.maxCharactersExceeded(label, max_lenght);
  }


  // TEXT
  public void validateText(String text) {
    if(utils.isNull(text)) return;
    Integer max_lenght = properties.getText_lenght();
    if(utils.isLengthGreaterThan(text, max_lenght)) ErrorsThrower.maxCharactersExceeded("Description", max_lenght);
  }


  // IMAGE
  public void validateImage(MultipartFile image){
    this.validateImage(image, false);
  }
  public void validateImage(MultipartFile image, Boolean isNullabe) {
    String label = "Media"; 
    if(isNullabe && utils.isNull(image)) return;
    if(utils.isNull(image)) ErrorsThrower.cantBeNull(label);
    if(!utils.isImageExtensionSupported(image, properties.getImage_extensions())) ErrorsThrower.validationError(label + " unsuported type");
    if(utils.isImageBiggerThanInMb(image, properties.getImage_size())) ErrorsThrower.validationError(label + " size is large than allowed");
  }


  // UUID
  public void validateUuid(String uuid) {
    validateUuid(uuid, false);
  }
  public void validateUuid(String uuid, boolean nullable) {
    String label = "Uuid";
    if(nullable == true && utils.isNull(uuid)) return;
    if(utils.isNullOrEmpty(uuid)) ErrorsThrower.cantBeNull(label);
    if(utils.isLengthDifferentFrom(uuid, 36)) ErrorsThrower.validationError(label + " must have exactly 36 characters");
    if(!utils.isUuidValid(uuid)) ErrorsThrower.validationError(label + " format is invalid");
  }

}
