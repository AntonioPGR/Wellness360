package com.wellness360.common.crud_default;

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
import com.wellness360.common.crud_default.interfaces.CrudUpdateDTO;

import jakarta.validation.Valid;

@SuppressWarnings({ "unchecked", "rawtypes" })
public abstract class CrudController<
  Service extends CrudService, 
  CreateDTO, 
  UpdateDTO extends CrudUpdateDTO,
  ReturnDTO
>{
  
  @Autowired
  private Service service;

  @GetMapping
  public ResponseEntity<Page<CreateDTO>> getAll(Pageable pageable){
    Page<CreateDTO> return_dto = service.getAll(pageable);
    return ResponseEntity.ok().body(return_dto);
  }

  @GetMapping("/{id}")
  public ResponseEntity<CreateDTO> getUnique(@PathVariable("id") String uuid) {
    Optional<CreateDTO> return_dto = service.getByUuid(uuid);
    if(return_dto.isPresent()){
      return ResponseEntity.ok().body(return_dto.get());
    }
    return ResponseEntity.notFound().build();
  }
  
  @PostMapping
  public ResponseEntity<URI> create(@RequestBody @Valid CreateDTO create_dto){
    Optional<URI> item_location = service.create(create_dto);
    if(item_location.isPresent()){
      return ResponseEntity.created(item_location.get()).build();
    }
    return ResponseEntity.status(201).build();
  }

  @PutMapping
  public ResponseEntity<ReturnDTO> edit(@RequestBody @Valid UpdateDTO update_dto){
    Optional<ReturnDTO> return_dto = service.update(update_dto);
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
