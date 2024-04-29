package com.wellness360.nutrition.selectivity;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.fasterxml.jackson.annotation.ObjectIdGenerators.None;
import com.wellness360.nutrition.selectivity.dtos.SelectivityCreateIdsDTO;
import com.wellness360.nutrition.selectivity.dtos.SelectivityReturnDTO;

public abstract class SelectivityController<
  Entity extends SelectivityBaseEntity
>{
  
  @Autowired
  SelectivityService<Entity> service;

  @GetMapping("/{uuid}")
  public ResponseEntity<List<SelectivityReturnDTO>> getByUserUUID(@PathVariable("uuid") String uuid) {
    List<SelectivityReturnDTO> return_dto = service.getByUserUuid(uuid);
    return ResponseEntity.ok().body(return_dto);
  }

  @PostMapping
  public ResponseEntity<None> create(@RequestBody SelectivityCreateIdsDTO dto) {
    service.create(dto);
    return ResponseEntity.status(201).build();
  }

  @DeleteMapping("/{uuid}")
  public ResponseEntity<None> delete(@PathVariable("uuid") String uuid) {
    service.deleteByUuid(uuid);
    return ResponseEntity.status(201).build();
  }

}
