package com.wellness360.nutrition.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.wellness360.nutrition.common.dtos.ExceptionReturnDTO;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.ValidationException;


@ControllerAdvice
public class ExceptionsHandler {

  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(EntityNotFoundException.class)
  public ResponseEntity<ExceptionReturnDTO> entityNotFound(EntityNotFoundException excp){
    ExceptionReturnDTO dto = new ExceptionReturnDTO(excp.getMessage());
    return ResponseEntity.badRequest().body(dto);
  }

  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(ValidationException.class)
  public ResponseEntity<ExceptionReturnDTO> validationError(ValidationException excp){
    ExceptionReturnDTO dto = new ExceptionReturnDTO(excp.getMessage());
    return ResponseEntity.badRequest().body(dto);
  }

}
