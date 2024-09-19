package com.wellness360.nutrition.packages.crud.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.fasterxml.jackson.annotation.ObjectIdGenerators.None;
import com.wellness360.nutrition.packages.crud.dtos.CrudCreateRequestDTO;
import com.wellness360.nutrition.packages.crud.dtos.CrudReturnDTO;
import com.wellness360.nutrition.packages.crud.dtos.CrudUpdateRequestDTO;
import com.wellness360.nutrition.packages.crud.service.interfaces.ICrudBaseService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@Controller
public abstract class CrudController<
  RequestCreateDTO extends CrudCreateRequestDTO,
  RequestUpdateDTO extends CrudUpdateRequestDTO,
  ReturnDTO extends CrudReturnDTO,
  Service extends ICrudBaseService<
    RequestCreateDTO,
    RequestUpdateDTO,
    ReturnDTO
  >
>{
  
  @Autowired
  Service service;

  @GetMapping
  public ResponseEntity<Page<ReturnDTO>> getAll(Pageable pageable){
    Page<ReturnDTO> return_dto = service.getAll(pageable);
    return ResponseEntity.ok().body(return_dto);
  }

  @GetMapping("/{id}")
  public ResponseEntity<ReturnDTO> getUnique(@PathVariable("id") String uuid) {
    ReturnDTO return_dto = service.getByUuid(uuid);
    return ResponseEntity.ok().body(return_dto);
  }
  
  @PostMapping
  public ResponseEntity<ReturnDTO> create(@Valid @RequestBody RequestCreateDTO request_dto, HttpServletRequest http ){
    ReturnDTO return_dto = (ReturnDTO) service.create(request_dto);
    URI item_location = URI.create(http.getRequestURL() + "/" + return_dto.uuid());
    return ResponseEntity
      .status(201)
      .header("Location", item_location.toString())
      .body(return_dto);
  }

  @PutMapping
  public ResponseEntity<ReturnDTO> update(@RequestBody @Valid RequestUpdateDTO request_dto){
    ReturnDTO return_dto = (ReturnDTO) service.update(request_dto);
    return ResponseEntity.ok().body(return_dto);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<None> delete(@PathVariable("id") String uuid){
    service.delete(uuid);
    return ResponseEntity.noContent().build();
  }

}
