package com.wellness360.nutrition.packages.crud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wellness360.nutrition.packages.crud.dtos.CrudCreateRequestDTO;
import com.wellness360.nutrition.packages.crud.dtos.CrudReturnDTO;
import com.wellness360.nutrition.packages.crud.dtos.CrudUpdateRequestDTO;
import com.wellness360.nutrition.packages.crud.entities.interfaces.CrudEntity;
import com.wellness360.nutrition.packages.crud.repositories.CrudRepository;
import com.wellness360.nutrition.packages.crud.service.interfaces.ICrudBaseService;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@SuppressWarnings("rawtypes")
@Transactional
public abstract class CrudBaseService<
  Repository extends CrudRepository<Entity>, 
  RequestCreateDTO extends CrudCreateRequestDTO,
  RequestUpdateDTO extends CrudUpdateRequestDTO,
  ReturnDTO extends CrudReturnDTO,
  Entity extends CrudEntity
> implements ICrudBaseService<
  RequestCreateDTO,
  RequestUpdateDTO,
  ReturnDTO
>{
  
  @Autowired
  Repository repository;

  // LIST
  public ReturnDTO getByUuid(String uuid) {
    Entity entity = getEntityByUuid(uuid);
    return buildReturnDTO(entity);
  }
  public Entity getEntityByUuid(String uuid) {
    return repository.findByUuid(uuid)
      .orElseThrow(() -> new EntityNotFoundException("Could not found an object with this uuid"));
  }

  // GET ALL
  public Page<ReturnDTO> getAll(Pageable pageable) {
    Page<Entity> entities = getAllAsEntity(pageable);
    return entities.map(this::buildReturnDTO);
  }
  public Page<Entity> getAllAsEntity(Pageable pageable) {
    return repository.findAll(pageable);
  }

  // DELETE
  public void delete(String uuid) {
    getEntityByUuid(uuid);
    repository.deleteByUuid(uuid);
  }

  // SAVE
  public Entity save(Entity new_entity){
    return repository.saveAndFlush(new_entity);
  }

  // ABSTRACT
  public abstract ReturnDTO buildReturnDTO(Entity entity);
  public abstract ReturnDTO create(RequestCreateDTO request_dto);
  public abstract Entity createAndGetEntity(RequestCreateDTO request_dto);
  public abstract ReturnDTO update(RequestUpdateDTO request_dto);
  public abstract Entity updateAndGetEntity(RequestUpdateDTO request_dto);

}
