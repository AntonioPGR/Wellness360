package com.wellness360.exercises.storage.validations.custom;

public class StorageFileNotFoundException extends StorageException {
  
  public StorageFileNotFoundException(String message){
    super(message);
  }

  public StorageFileNotFoundException(String message, Throwable cause){
    super(message, cause);
  }

}
