package com.wellness360.nutrition.packages.storage.validations;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.wellness360.nutrition.packages.storage.validations.custom.StorageException;
import com.wellness360.nutrition.packages.storage.validations.custom.StorageFileNotFoundException;
import com.wellness360.nutrition.packages.validation.dtos.ExceptionReturnDTO;

@ControllerAdvice
public class StorageExceptionsHandler {

  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler({
    StorageException.class,
    StorageFileNotFoundException.class
  })
  public ResponseEntity<ExceptionReturnDTO> validationError(Exception excp){
    ExceptionReturnDTO dto = new ExceptionReturnDTO(excp.getMessage());
    return ResponseEntity.badRequest().body(dto);
  }

}
