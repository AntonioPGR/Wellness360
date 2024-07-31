package com.wellness360.community.packages.crud.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wellness360.community.packages.crud.dtos.CrudCreatePersistenceDTO;
import com.wellness360.community.packages.crud.dtos.CrudCreateRequestDTO;
import com.wellness360.community.packages.crud.dtos.CrudReturnDTO;
import com.wellness360.community.packages.crud.dtos.CrudUpdatePersistenceDTO;
import com.wellness360.community.packages.crud.dtos.CrudUpdateRequestDTO;
import com.wellness360.community.packages.crud.entities.interfaces.ICrudEntity;
import com.wellness360.community.packages.crud.repositories.CrudRepository;
import com.wellness360.community.packages.crud.service.interfaces.ICrudDtoTransformService;
import com.wellness360.community.packages.validation.ValidateService;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Transactional
public abstract class CrudDtoTransformService<
  Repository extends CrudRepository<Entity>, 
  RequestCreateDTO extends CrudCreateRequestDTO,
  PersistenceCreateDTO extends CrudCreatePersistenceDTO, 
  RequestUpdateDTO extends CrudUpdateRequestDTO,
  PersistenceUpdateDTO extends CrudUpdatePersistenceDTO,
  ReturnDTO extends CrudReturnDTO,
  Entity extends ICrudEntity<PersistenceUpdateDTO>
> implements ICrudDtoTransformService<
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
