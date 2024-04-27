package com.wellness360.common.controllers;

import java.net.URI;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.fasterxml.jackson.annotation.ObjectIdGenerators.None;
import com.wellness360.common.interfaces.CrudUpdateDTO;
import com.wellness360.common.services.FullCrudService;

import jakarta.validation.Valid;

@SuppressWarnings({ "unchecked", "rawtypes" })
public abstract class FullCrudController<
  Service extends FullCrudService, 
  CreateDTO, 
  UpdateDTO extends CrudUpdateDTO,
  ReturnDTO
>{
  
  @Autowired
  protected Service service;

  protected abstract Optional<URI> createEntity(CreateDTO create_dto);
  protected abstract Optional<ReturnDTO> updateEntity(UpdateDTO update_dto);

  @GetMapping
  public ResponseEntity<Page<ReturnDTO>> getAll(Pageable pageable){
    Page<ReturnDTO> return_dto = service.getAll(pageable);
    return ResponseEntity.ok().body(return_dto);
  }

  @GetMapping("/{id}")
  public ResponseEntity<ReturnDTO> getUnique(@PathVariable("id") String uuid) {
    Optional<ReturnDTO> return_dto = service.getByUuid(uuid);
    if(return_dto.isPresent()){
      return ResponseEntity.ok().body(return_dto.get());
    }
    return ResponseEntity.notFound().build();
  }
  
  @PostMapping
  public ResponseEntity create(@RequestBody @Valid CreateDTO create_dto){
    Optional<URI> item_location = createEntity(create_dto);
    if(item_location.isPresent()){
      return ResponseEntity.created(item_location.get()).build();
    }
    return ResponseEntity.status(201).header("Location", "https://localhost.com").build();
  }

  @PutMapping
  public ResponseEntity<ReturnDTO> edit(@RequestBody @Valid UpdateDTO update_dto){
    Optional<ReturnDTO> return_dto = updateEntity(update_dto);
    if(return_dto.isPresent()){
      return ResponseEntity.ok().body(return_dto.get());
    }
    return ResponseEntity.notFound().build();
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<None> delete(@PathVariable("id") String category_uuid){
    service.delete(category_uuid);
    return ResponseEntity.noContent().build();
  }

}
