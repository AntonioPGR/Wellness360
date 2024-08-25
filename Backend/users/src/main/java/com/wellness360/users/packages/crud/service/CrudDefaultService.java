package com.wellness360.users.packages.crud.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.wellness360.users.packages.crud.dtos.CrudCreateRequestDTO;
import com.wellness360.users.packages.crud.dtos.CrudReturnDTO;
import com.wellness360.users.packages.crud.dtos.CrudUpdateRequestDTO;
import com.wellness360.users.packages.crud.entities.interfaces.ICrudEntity;
import com.wellness360.users.packages.crud.repositories.CrudRepository;
import com.wellness360.users.validation.Validator;

import jakarta.transaction.Transactional;

@Transactional
public abstract class CrudDefaultService<
  Repository extends CrudRepository<Entity>, 
  RequestCreateDTO extends CrudCreateRequestDTO,
  RequestUpdateDTO extends CrudUpdateRequestDTO,
  ReturnDTO extends CrudReturnDTO,
  Entity extends ICrudEntity<RequestUpdateDTO>
> extends CrudBaseService<
  Repository,
  RequestCreateDTO,
  RequestUpdateDTO,
  ReturnDTO,
  Entity
>{

  @Autowired
  protected Validator validator_service;

  // CREATE
  public ReturnDTO create(RequestCreateDTO request_dto){
    Entity created_entity = createAndGetEntity(request_dto);
    return buildReturnDTO(created_entity);
  }
  public Entity createAndGetEntity(RequestCreateDTO request_dto){
    request_dto.validate(validator_service);
    Entity created_entity = buildEntity(request_dto);
    return save(created_entity);
  }

  // UPDATE
  public ReturnDTO update(RequestUpdateDTO request_dto) {
    Entity entity = updateAndGetEntity(request_dto);
    return buildReturnDTO(entity);
  }
  public Entity updateAndGetEntity(RequestUpdateDTO request_dto){
    request_dto.validate(validator_service);
    Entity entity = getEntityByUuid(request_dto.uuid());
    entity.update(request_dto);
    return save(entity);
  }

  // ABSTRACT
  public abstract Entity buildEntity(RequestCreateDTO dto);

}
