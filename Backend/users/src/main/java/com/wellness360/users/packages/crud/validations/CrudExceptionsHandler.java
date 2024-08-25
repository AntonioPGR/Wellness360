package com.wellness360.users.packages.crud.validations;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.wellness360.users.packages.validation.dtos.ExceptionReturnDTO;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.ValidationException;


@ControllerAdvice
public class CrudExceptionsHandler {

  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler({
    EntityNotFoundException.class,
    ValidationException.class
  })
  public ResponseEntity<ExceptionReturnDTO> validation(Exception excp){
    ExceptionReturnDTO dto = new ExceptionReturnDTO(excp.getMessage());
    return ResponseEntity.badRequest().body(dto);
  }

  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler({
    DataIntegrityViolationException.class
  })
  public ResponseEntity<ExceptionReturnDTO> duplicateEntry(Exception excp){
    String message = excp.getMessage();
    String cause = message.substring(message.indexOf("key '")+5, message.indexOf("']"));

    ExceptionReturnDTO dto = new ExceptionReturnDTO("Duplicate entry not allowed: "+ cause);
    return ResponseEntity.badRequest().body(dto);
  }

  

}
