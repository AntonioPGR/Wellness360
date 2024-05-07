package com.wellness360.nutrition.common.CrudBases;

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
import com.wellness360.nutrition.common.interfaces.UuidDTO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;


@SuppressWarnings({"unchecked", "rawtypes"})
public abstract class CrudController<
  CreateDTO, 
  UpdateDTO extends UuidDTO,
  ReturnDTO extends UuidDTO,
  Service extends CrudService
>{
  
  @Autowired
  protected Service service;

  public abstract ReturnDTO createEntity(CreateDTO dto);
  public abstract Optional<ReturnDTO> updateEntity(UpdateDTO dto);

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
  public ResponseEntity<ReturnDTO> create(@RequestBody @Valid CreateDTO create_dto, HttpServletRequest http ){
    ReturnDTO return_dto = createEntity(create_dto);
    URI item_location = URI.create(http.getRequestURL() + "/" + return_dto.getUuid());
    return ResponseEntity
      .status(201)
      .header("Location", item_location.toString())
      .body(return_dto);
  }

  @PutMapping
  public ResponseEntity<ReturnDTO> update(@RequestBody @Valid UpdateDTO update_dto){
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
