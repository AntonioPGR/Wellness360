package com.wellness360.users.packages.validation;


import com.wellness360.users.packages.storage.validations.custom.StorageException;
import com.wellness360.users.packages.storage.validations.custom.StorageFileNotFoundException;

import jakarta.validation.ValidationException;

public class ErrorsThrower {
  
  // CUSTOM
  public static void cantBeNull(String label){
    validationError(label + " cannot be null");
  }
  public static void maxCharactersExceeded(String label, Integer lenght){
    validationError(label + " cannot have more than " + lenght + " characters");
  }
  public static void cantBeEmpty(String label) {
    validationError(label + " cannot be empty");
  }

  // ERRORS
  public static void validationError(String message){
    throw new ValidationException(message);
  }
  public static void storageError(String message){
    throw new StorageException(message);
  }
  public static void fileNotFound(String message){
    throw new StorageFileNotFoundException(message);
  }

}
