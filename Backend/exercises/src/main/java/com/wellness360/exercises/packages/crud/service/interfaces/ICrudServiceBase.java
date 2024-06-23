package com.wellness360.exercises.packages.crud.service.interfaces;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wellness360.exercises.packages.crud.dtos.CrudCreateRequestDTO;
import com.wellness360.exercises.packages.crud.dtos.CrudReturnDTO;
import com.wellness360.exercises.packages.crud.dtos.CrudUpdateRequestDTO;

public interface ICrudServiceBase <
  RequestCreateDTO extends CrudCreateRequestDTO,
  RequestUpdateDTO extends CrudUpdateRequestDTO,
  ReturnDTO extends CrudReturnDTO
> {
  
  public ReturnDTO getByUuid(String uuid);
  public Page<ReturnDTO> getAll(Pageable pageable);
  public ReturnDTO create(RequestCreateDTO create_dto);
  public ReturnDTO update(RequestUpdateDTO update_dto);
  public void delete(String uuid);

}
