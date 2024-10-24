package com.wellness360.nutrition.security;

import org.apache.logging.log4j.util.InternalException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.wellness360.nutrition.packages.crud.validations.UnauthorizedOperation;
import com.wellness360.nutrition.packages.validation.dtos.ExceptionReturnDTO;

@ControllerAdvice
public class AuthExceptionHandler {

  @ResponseStatus(HttpStatus.UNAUTHORIZED)
  @ExceptionHandler({
    UnauthorizedOperation.class
  })
  public ResponseEntity<ExceptionReturnDTO> notAuthenticated(Exception excp){
    String message = excp.getMessage();
    ExceptionReturnDTO dto = new ExceptionReturnDTO(message);
    return ResponseEntity.status(401).body(dto);
  }

  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  @ExceptionHandler({
    InternalException.class
  })
  public ResponseEntity<ExceptionReturnDTO> internalExcp(Exception excp){
    String message = excp.getMessage();
    ExceptionReturnDTO dto = new ExceptionReturnDTO(message);
    return ResponseEntity.status(500).body(dto);
  }
  
}
