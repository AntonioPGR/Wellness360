package com.wellness360.users.packages.crud.controllers;

import java.net.URI;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.wellness360.users.packages.crud.dtos.CrudCreateRequestDTO;
import com.wellness360.users.packages.crud.dtos.CrudReturnDTO;
import com.wellness360.users.packages.crud.dtos.CrudUpdateRequestDTO;
import com.wellness360.users.packages.crud.service.interfaces.ICrudBaseService;

import jakarta.servlet.http.HttpServletRequest;

public abstract class CrudStorageController<
  CreateDTO extends CrudCreateRequestDTO, 
  UpdateDTO extends CrudUpdateRequestDTO,
  ReturnDTO extends CrudReturnDTO,
  Service extends ICrudBaseService<
    CreateDTO,
    UpdateDTO,
    ReturnDTO
  >
> extends CrudController<
  CreateDTO,
  UpdateDTO,
  ReturnDTO,
  Service
> {
  
  @Override
  @PostMapping(consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
  public ResponseEntity<ReturnDTO> create(@ModelAttribute CreateDTO request_dto, HttpServletRequest http ){
    ReturnDTO return_dto = service.create(request_dto);
    URI item_location = URI.create(http.getRequestURL() + "/" + return_dto.uuid());
    return ResponseEntity
      .status(201)
      .header("Location", item_location.toString())
      .body(return_dto);
  }

  @Override
  @PutMapping(consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
  public ResponseEntity<ReturnDTO> update(@ModelAttribute UpdateDTO request_dto){
    ReturnDTO return_dto = service.update(request_dto);
    return ResponseEntity.ok().body(return_dto);
  }

}
