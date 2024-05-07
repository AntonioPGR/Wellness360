package com.wellness360.nutrition.common.CrudBases;

import java.util.Optional;
import javax.swing.text.html.parser.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wellness360.nutrition.common.interfaces.BaseEntity;
import com.wellness360.nutrition.common.interfaces.UuidDTO;
import com.wellness360.nutrition.common.repositories.UUIDRepository;

import jakarta.transaction.Transactional;

@Transactional
@SuppressWarnings("hiding")
public abstract class CrudService<
  Repository extends UUIDRepository<Entity>, 
  CreateDTO, 
  UpdateDTO extends UuidDTO,
  ReturnDTO,
  Entity extends BaseEntity<UpdateDTO>
> {

  @Autowired
  protected Repository repository;

  // METHODS
  public Optional<ReturnDTO> getByUuid(String uuid) {
    Optional<Entity> optional = findEntityByUuid(uuid);
    if(optional.isEmpty()) return Optional.empty();
    ReturnDTO return_dto = this.entityToReturnDTO(optional.get());
    return Optional.of(return_dto);
  }

  public Page<ReturnDTO> getAll(Pageable pageable) {
    Page<Entity> item = repository.findAll(pageable);
    Page<ReturnDTO> return_dto = item.map(this::entityToReturnDTO);
    return return_dto;
  }

  public ReturnDTO create(CreateDTO create_dto){
    Entity new_entity = createDTOtoEntity(create_dto);
    return save(new_entity);
  }

  public Entity createReturnEntityAndFlush(CreateDTO create_dto){
    Entity new_entity = createDTOtoEntity(create_dto);
    return repository.saveAndFlush(new_entity);
  }

  public Optional<ReturnDTO> update(UpdateDTO update_dto) {
    Optional<Entity> optional = findEntityByUuid(update_dto.getUuid());
    if(optional.isEmpty()) return Optional.empty();
    Entity entity = optional.get();
    entity.update(update_dto);
    save(entity);
    ReturnDTO return_dto = entityToReturnDTO(entity);
    return Optional.of(return_dto);
  }

  public void delete(String uuid) {
    repository.deleteByUuid(uuid);
  }

  // COMMONS
  public ReturnDTO save(Entity new_entity){
    Entity created_entity = repository.saveAndFlush(new_entity);
    return entityToReturnDTO(created_entity);
  }

  public Optional<Entity> findEntityByUuid(String uuid){
    return repository.findByUuid(uuid);
  }

  // INHERIT
  public abstract ReturnDTO entityToReturnDTO(Entity entity);
  public abstract Entity createDTOtoEntity(CreateDTO dto);
  

}
