package com.wellness360.exercises.crud.validations;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.wellness360.exercises.validation.ExceptionReturnDTO;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.ValidationException;


@ControllerAdvice
public class CrudExceptionsHandler {

  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler({
    EntityNotFoundException.class,
    ValidationException.class
  })
  public ResponseEntity<ExceptionReturnDTO> entityNotFound(Exception excp){
    ExceptionReturnDTO dto = new ExceptionReturnDTO(excp.getMessage());
    return ResponseEntity.badRequest().body(dto);
  }

}
