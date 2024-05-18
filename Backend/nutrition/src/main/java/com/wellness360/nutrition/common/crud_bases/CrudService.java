package com.wellness360.nutrition.common.crud_bases;

import java.util.Optional;
import javax.swing.text.html.parser.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wellness360.nutrition.common.crud_bases.interfaces.BaseEntity;
import com.wellness360.nutrition.common.crud_bases.interfaces.ICrudService;
import com.wellness360.nutrition.common.crud_bases.interfaces.UuidDTO;
import com.wellness360.nutrition.common.crud_bases.repositories.UUIDRepository;

import jakarta.transaction.Transactional;

@Transactional
@SuppressWarnings("hiding")
public abstract class CrudService<
  Repository extends UUIDRepository<Entity>, 
  RequestCreateDTO,
  PersistenceCreateDTO, 
  RequestUpdateDTO extends UuidDTO,
  PersistenceUpdateDTO extends UuidDTO,
  ReturnDTO,
  Entity extends BaseEntity<PersistenceUpdateDTO>
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

  // LIST
  public Optional<ReturnDTO> getByUuid(String uuid) {
    Optional<Entity> optional = getEntityByUuid(uuid);

    if(optional.isEmpty())return Optional.empty();

    ReturnDTO return_dto = getReturnDTO(optional.get());
    return Optional.of(return_dto);
  }

  public Page<ReturnDTO> getAll(Pageable pageable) {
    Page<Entity> item = repository.findAll(pageable);
    Page<ReturnDTO> return_dto = item.map(this::getReturnDTO);
    return return_dto;
  }

  public ReturnDTO create(RequestCreateDTO request_dto){
    PersistenceCreateDTO create_dto = getPersistenceCreateDTO(request_dto);
    Entity created_entity = getEntity(create_dto);
    created_entity = saveEntity(created_entity);
    return getReturnDTO(created_entity);
  }

  // UPDATE
  public Optional<ReturnDTO> update(RequestUpdateDTO request_dto) {
    Optional<Entity> optional = getEntityByUuid(request_dto.getUuid());
    if(optional.isEmpty()) return Optional.empty();
    Entity entity = optional.get();

    PersistenceUpdateDTO persistence_dto = getPersistenceUpdateDTO(request_dto);
    entity.update(persistence_dto);
    saveEntity(entity);

    return Optional.of(getReturnDTO(entity));
  }

  // DELETE
  public void delete(String uuid) {
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
