package com.wellness360.exercises.storage.controller;

import java.net.URI;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.wellness360.exercises.crud.controllers.CrudController;
import com.wellness360.exercises.crud.dtos.UpdateRequestDTO;
import com.wellness360.exercises.crud.dtos.UuidDTO;
import com.wellness360.exercises.crud.dtos.ValidatableDTO;
import com.wellness360.exercises.crud.service.CrudService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@SuppressWarnings({"rawtypes", "unchecked"})
public abstract class CrudStorageController<
  CreateDTO extends ValidatableDTO, 
  UpdateDTO extends UpdateRequestDTO,
  ReturnDTO extends UuidDTO,
  Service extends CrudService
> extends CrudController<
  CreateDTO,
  UpdateDTO,
  ReturnDTO,
  Service
> {
  
  @Override
  @PostMapping(consumes = {MediaType.MULTIPART_FORM_DATA_VALUE} )
  public ResponseEntity<ReturnDTO> create(@ModelAttribute @Valid CreateDTO request_dto, HttpServletRequest http ){
    ReturnDTO return_dto = (ReturnDTO) service.create(request_dto);
    URI item_location = URI.create(http.getRequestURL() + "/" + return_dto.getUuid());
    return ResponseEntity
      .status(201)
      .header("Location", item_location.toString())
      .body(return_dto);
  }

  @Override
  @PutMapping(consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
  public ResponseEntity<ReturnDTO> update(@ModelAttribute @Valid UpdateDTO request_dto){
    ReturnDTO return_dto = (ReturnDTO) service.update(request_dto);
    return ResponseEntity.ok().body(return_dto);
  }

}
