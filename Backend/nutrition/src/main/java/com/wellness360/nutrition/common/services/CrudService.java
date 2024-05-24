package com.wellness360.nutrition.common.services;

import java.util.Optional;
import javax.swing.text.html.parser.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wellness360.nutrition.common.dtos.UpdateRequestDTO;
import com.wellness360.nutrition.common.dtos.UuidDTO;
import com.wellness360.nutrition.common.dtos.ValidatableDTO;
import com.wellness360.nutrition.common.interfaces.IBaseEntity;
import com.wellness360.nutrition.common.interfaces.ICrudService;
import com.wellness360.nutrition.common.repositories.UUIDRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Transactional
@SuppressWarnings("hiding")
public abstract class CrudService<
  Repository extends UUIDRepository<Entity>, 
  RequestCreateDTO extends ValidatableDTO,
  PersistenceCreateDTO, 
  RequestUpdateDTO extends UpdateRequestDTO,
  PersistenceUpdateDTO extends UuidDTO,
  ReturnDTO,
  Entity extends IBaseEntity<PersistenceUpdateDTO>
> implements ICrudService<
  RequestCreateDTO,
  PersistenceCreateDTO, 
  RequestUpdateDTO, 
  PersistenceUpdateDTO,
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
    PersistenceCreateDTO create_dto = getPersistenceCreateDTO(request_dto);
    Entity created_entity = getEntity(create_dto);
    created_entity = saveEntity(created_entity);
    return getReturnDTO(created_entity);
  }

  // UPDATE
  public ReturnDTO update(RequestUpdateDTO request_dto) {
    request_dto.validate(validator_service);
    Entity entity = getEntityByUuid(request_dto.getUuid())
      .orElseThrow(() -> new EntityNotFoundException("Unable to find object with passed uuid"));

    PersistenceUpdateDTO persistence_dto = getPersistenceUpdateDTO(request_dto);
    entity.update(persistence_dto);
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
