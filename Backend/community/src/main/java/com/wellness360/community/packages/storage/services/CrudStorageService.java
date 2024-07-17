package com.wellness360.exercises.packages.storage.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.wellness360.exercises.packages.crud.dtos.CrudCreatePersistenceDTO;
import com.wellness360.exercises.packages.crud.dtos.CrudReturnDTO;
import com.wellness360.exercises.packages.crud.dtos.CrudUpdatePersistenceDTO;
import com.wellness360.exercises.packages.crud.repositories.CrudRepository;
import com.wellness360.exercises.packages.storage.StorageService;
import com.wellness360.exercises.packages.storage.dtos.CrudStorageCreateRequestDTO;
import com.wellness360.exercises.packages.storage.dtos.CrudStorageUpdateRequestDTO;
import com.wellness360.exercises.packages.storage.services.interfaces.ICrudStorageService;
import com.wellness360.exercises.packages.storage.services.interfaces.IStorageEntity;
import com.wellness360.exercises.packages.validation.ValidateService;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.ValidationException;

@Service
@Transactional
public abstract class CrudStorageService<
  Repository extends CrudRepository<Entity>, 
  RequestCreateDTO extends CrudStorageCreateRequestDTO,
  PersistenceCreateDTO extends CrudCreatePersistenceDTO, 
  RequestUpdateDTO extends CrudStorageUpdateRequestDTO,
  PersistenceUpdateDTO extends CrudUpdatePersistenceDTO,
  ReturnDTO extends CrudReturnDTO,
  Entity extends IStorageEntity<PersistenceUpdateDTO>
> implements ICrudStorageService <
  RequestCreateDTO,
  PersistenceCreateDTO,
  RequestUpdateDTO,
  PersistenceUpdateDTO,
  ReturnDTO,
  Entity
> {

  @Autowired
  protected StorageService store_service;
  @Autowired
  protected Repository repository;
  @Autowired
  protected ValidateService validator_service;

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
    String file_name = store_service.store(request_dto.getFile(), getFolderName(), request_dto.getName());
    PersistenceCreateDTO create_dto = getPersistenceCreateDTO(request_dto, file_name);
    Entity entity = getEntity(create_dto);
    entity = saveEntity(entity);

    // store_service.delete(file_name);
    // String uuid_file_name = store_service.store(request_dto.getFile(), getFolderName(), entity.getUuid());
    // entity = getEntityByUuid(entity.getUuid()).orElseThrow(() -> new ValidationException("VAI TOMA NO CU"));
    // entity.setImage_url(uuid_file_name);
    // ERRO AQUI! APENAS PARA EXERCÍCIOS
    // EQUIPMENTS FUNCIONANDO NORMAL
    // GOOGLE DIZ QUE È ALGO A VER COM ARRYS E LISTAS
    // System.out.println(entity.getImage_url());
    // System.out.println(entity.getUuid());
    // entity = saveEntity(entity);

    return getReturnDTO(entity);
  }

  public ReturnDTO update(RequestUpdateDTO request_dto) {
    request_dto.validate(validator_service);
    Entity entity = getEntityByUuid(request_dto.getUuid())
      .orElseThrow(() -> new EntityNotFoundException("Unable to find object with passed uuid"));
    String file_name = store_service.update(request_dto.getFile(), entity.getImage_url());
    PersistenceUpdateDTO persistence_dto = getPersistenceUpdateDTO(request_dto, file_name);
    entity.update(persistence_dto);
    saveEntity(entity);

    return getReturnDTO(entity);
  }
  
  public void delete(String uuid) {
    Entity entity = getEntityByUuid(uuid)
      .orElseThrow(() -> new EntityNotFoundException("Unable to find object with uuid"));
    try{ store_service.delete(entity.getImage_url()); } catch (ValidationException e) {}
    repository.deleteByUuid(uuid);
  }

  public Entity saveEntity(Entity new_entity){
    return repository.saveAndFlush(new_entity);
  }

  public Optional<Entity> getEntityByUuid(String uuid){
    return repository.findByUuid(uuid);
  }

}
