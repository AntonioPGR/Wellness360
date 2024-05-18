package com.wellness360.nutrition.exceptions.handlers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.wellness360.nutrition.exceptions.handlers.dto.ExceptionReturnDTO;

import jakarta.persistence.EntityNotFoundException;

@RestControllerAdvice
public class CrudExceptionsHandler {
  
  @ExceptionHandler(EntityNotFoundException.class)
  public ResponseEntity<ExceptionReturnDTO> entityNotFound(EntityNotFoundException excp){
    ExceptionReturnDTO dto = new ExceptionReturnDTO("Unable to find entity with the information passed: " + excp.getMessage());
    return ResponseEntity.badRequest().body(dto);
  }

}
