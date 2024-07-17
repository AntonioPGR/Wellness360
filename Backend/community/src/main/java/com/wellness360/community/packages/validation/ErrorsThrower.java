package com.wellness360.exercises.packages.validation;


import com.wellness360.exercises.packages.storage.validations.custom.StorageException;
import com.wellness360.exercises.packages.storage.validations.custom.StorageFileNotFoundException;

import jakarta.validation.ValidationException;

public class ErrorsThrower {
  
  // CUSTOM
  public static void cantBeNull(String label){
    validationError(label + " cannot be null");
  }
  public static void maxCharactersExceeded(String label, Integer lenght){
    validationError(label + " cannot have more than " + lenght + " characters");
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
