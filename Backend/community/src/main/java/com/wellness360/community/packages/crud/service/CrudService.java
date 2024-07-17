package com.wellness360.exercises.packages.crud.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wellness360.exercises.packages.crud.dtos.CrudCreateRequestDTO;
import com.wellness360.exercises.packages.crud.dtos.CrudReturnDTO;
import com.wellness360.exercises.packages.crud.dtos.CrudUpdateRequestDTO;
import com.wellness360.exercises.packages.crud.entities.interfaces.IBaseEntity;
import com.wellness360.exercises.packages.crud.repositories.CrudRepository;
import com.wellness360.exercises.packages.crud.service.interfaces.ICrudService;
import com.wellness360.exercises.packages.validation.ValidateService;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Transactional
public abstract class CrudService<
  Repository extends CrudRepository<Entity>, 
  RequestCreateDTO extends CrudCreateRequestDTO,
  RequestUpdateDTO extends CrudUpdateRequestDTO,
  ReturnDTO extends CrudReturnDTO,
  Entity extends IBaseEntity<RequestUpdateDTO>
> implements ICrudService<
  RequestCreateDTO,
  RequestUpdateDTO, 
  ReturnDTO, 
  Entity
> {

  @Autowired
  protected Repository repository;

  @Autowired
  protected ValidateService validator_service;

  // LIST
  public ReturnDTO getByUuid(String uuid) {
    Entity entity = getEntityByUuid(uuid)
      .orElseThrow(() -> new EntityNotFoundException("Could not found an object with this uuid"));
    ReturnDTO return_dto = getReturnDTO(entity);
    return return_dto;
  }

  public Page<ReturnDTO> getAll(Pageable pageable) {
    Page<Entity> item = repository.findAll(pageable);
    Page<ReturnDTO> return_dto = item.map(this::getReturnDTO);
    return return_dto;
  }

  public ReturnDTO create(RequestCreateDTO request_dto){
    request_dto.validate(validator_service);
    Entity created_entity = getEntity(request_dto);
    created_entity = saveEntity(created_entity);
    return getReturnDTO(created_entity);
  }

  // UPDATE
  public ReturnDTO update(RequestUpdateDTO request_dto) {
    request_dto.validate(validator_service);
    Entity entity = getEntityByUuid(request_dto.getUuid())
      .orElseThrow(() -> new EntityNotFoundException("Unable to find object with passed uuid"));

    entity.update(request_dto);
    saveEntity(entity);

    return getReturnDTO(entity);
  }

  // DELETE
  public void delete(String uuid) {
    getEntityByUuid(uuid)
      .orElseThrow(() -> new EntityNotFoundException("Could not found an object with this uuid"));
    repository.deleteByUuid(uuid);
  }

  // COMMONS
  public Entity saveEntity(Entity new_entity){
    return repository.saveAndFlush(new_entity);
  }

  public Optional<Entity> getEntityByUuid(String uuid){
    return repository.findByUuid(uuid);
  }

}
