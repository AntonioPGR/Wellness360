package com.wellness360.nutrition.packages.crud.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.wellness360.nutrition.packages.crud.dtos.CrudCreatePersistenceDTO;
import com.wellness360.nutrition.packages.crud.dtos.CrudCreateRequestDTO;
import com.wellness360.nutrition.packages.crud.dtos.CrudReturnDTO;
import com.wellness360.nutrition.packages.crud.dtos.CrudUpdatePersistenceDTO;
import com.wellness360.nutrition.packages.crud.dtos.CrudUpdateRequestDTO;
import com.wellness360.nutrition.packages.crud.entities.interfaces.CrudEntity;
import com.wellness360.nutrition.packages.crud.repositories.CrudRepository;
import com.wellness360.nutrition.validation.Validator;

import jakarta.transaction.Transactional;


@Transactional
public abstract class CrudDtoTransformService<
  Repository extends CrudRepository<Entity>, 
  RequestCreateDTO extends CrudCreateRequestDTO,
  PersistenceCreateDTO extends CrudCreatePersistenceDTO, 
  RequestUpdateDTO extends CrudUpdateRequestDTO,
  PersistenceUpdateDTO extends CrudUpdatePersistenceDTO,
  ReturnDTO extends CrudReturnDTO,
  Entity extends CrudEntity<PersistenceUpdateDTO>
> extends CrudBaseService<
  Repository,
  RequestCreateDTO,
  RequestUpdateDTO,
  ReturnDTO,
  Entity
>{

  @Autowired
  Validator validator_service;

  // CREATE
  public ReturnDTO create(RequestCreateDTO request_dto){
    Entity entity = createAndGetEntity(request_dto);
    return buildReturnDTO(entity);
  }
  public Entity createAndGetEntity(RequestCreateDTO request_dto){
    request_dto.validate(validator_service);
    PersistenceCreateDTO create_dto = getPersistenceCreateDTO(request_dto);
    Entity entity = getEntityByPersistenceDTO(create_dto);
    return save(entity);
  }

  // UPDATE
  public ReturnDTO update(RequestUpdateDTO request_dto) {
    Entity entity = updateAndGetEntity(request_dto);
    return buildReturnDTO(entity);
  }
  public Entity updateAndGetEntity(RequestUpdateDTO request_dto) {
    request_dto.validate(validator_service);
    Entity entity = getEntityByUuid(request_dto.uuid());
    PersistenceUpdateDTO persistence_dto = getPersistenceUpdateDTO(request_dto);
    entity.update(persistence_dto);
    return save(entity);
  }

  // ABSTRACT
  public abstract Entity getEntityByPersistenceDTO(PersistenceCreateDTO dto);
  public abstract PersistenceCreateDTO getPersistenceCreateDTO(RequestCreateDTO dto);
  public abstract PersistenceUpdateDTO getPersistenceUpdateDTO(RequestUpdateDTO dto);


}
