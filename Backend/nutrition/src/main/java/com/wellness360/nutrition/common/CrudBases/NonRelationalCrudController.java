package com.wellness360.nutrition.common.CrudBases;

import java.util.Optional;

import com.wellness360.nutrition.common.interfaces.UuidDTO;

@SuppressWarnings({"rawtypes", "unchecked"})
public class NonRelationalCrudController<
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
  public ReturnDTO createEntity(CreateDTO dto) {
    return (ReturnDTO) service.create(dto);
  }

  @Override
  public Optional<ReturnDTO> updateEntity(UpdateDTO dto) {
    return service.update(dto);
  }

}
