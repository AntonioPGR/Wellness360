package com.wellness360.nutrition.packages.crud.service.interfaces;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICrudBaseService<
  CreateDTO,
  UpdateDTO,
  ReturnDTO
>{

  public abstract ReturnDTO getByUuid(String uuid);
  public abstract Page<ReturnDTO> getAll(Pageable pageable) ;
  public abstract void delete(String uuid);
  public abstract ReturnDTO create(CreateDTO request_dto);
  public abstract ReturnDTO update(UpdateDTO request_dto);
  
}
