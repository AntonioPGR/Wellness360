package com.wellness360.nutrition.common.crud_bases;

import java.net.URI;
import java.util.Optional;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.wellness360.nutrition.common.crud_bases.interfaces.UuidDTO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@SuppressWarnings({"rawtypes", "unchecked"})
public abstract class CrudImageController<
  CreateDTO, 
  UpdateDTO extends UuidDTO,
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
    Optional<ReturnDTO> return_dto = service.update(request_dto);
    if(return_dto.isPresent()){
      return ResponseEntity.ok().body(return_dto.get());
    }
    return ResponseEntity.notFound().build();
  }

}
