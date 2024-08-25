package com.wellness360.users.packages.crud.validations;

public class UnauthorizedOperation extends RuntimeException {
  
  public UnauthorizedOperation(String message){
    super(message);
  }

}
