package com.wellness360.exercises.packages.storage.validations.custom;

public class StorageException extends RuntimeException {
  
  public StorageException(String message){
    super(message);
  }

  public StorageException(String message, Throwable cause){
    super(message, cause);
  }

}
