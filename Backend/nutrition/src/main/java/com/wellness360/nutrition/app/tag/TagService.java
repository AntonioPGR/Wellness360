package com.wellness360.nutrition.app.tag;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.wellness360.nutrition.app.category.CategoryEntity;
import com.wellness360.nutrition.app.tag.dtos.TagCreatePersistenceDTO;
import com.wellness360.nutrition.app.tag.dtos.TagCreateRequestDTO;
import com.wellness360.nutrition.app.tag.dtos.TagReturnCompleteDTO;
import com.wellness360.nutrition.app.tag.dtos.TagReturnSimplifiedDTO;
import com.wellness360.nutrition.app.tag.dtos.TagUpdatePersistenceDTO;
import com.wellness360.nutrition.app.tag.dtos.TagUpdateRequestDTO;
import com.wellness360.nutrition.common.crud_bases.CrudService;
import com.wellness360.nutrition.common.media_storage.StorageEntityFileService;
import com.wellness360.nutrition.common.media_storage.StorageFolders;
import com.wellness360.nutrition.tools.EntityRetrieverByUUID;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class TagService extends CrudService<
  TagRepository,
  TagCreateRequestDTO,
  TagCreatePersistenceDTO,
  TagUpdateRequestDTO,
  TagUpdatePersistenceDTO,
  TagReturnCompleteDTO,
  TagEntity
>{

  @Autowired
  StorageEntityFileService store_service;
  @Autowired
  EntityRetrieverByUUID entity_retriever;
  StorageFolders folder = StorageFolders.tag;

  // INHERIT
  @Override
  public TagReturnCompleteDTO getReturnDTO(TagEntity entity) {
    return new TagReturnCompleteDTO(entity);
  }
  @Override
  public TagEntity getEntity(TagCreatePersistenceDTO dto) {
    return new TagEntity(dto);
  }

  public TagCreatePersistenceDTO getPersistenceCreateDTO(TagCreateRequestDTO request_dto){
    CategoryEntity category = entity_retriever.getCategoryByUuid(request_dto.getCategory_uuid()).get();

    String media_path = store_service.create(
      request_dto.getName(), 
      folder.name(), 
      request_dto.getImage()
    );
    return new TagCreatePersistenceDTO(request_dto, media_path, category);
  }

  public TagUpdatePersistenceDTO getPersistenceUpdateDTO(TagUpdateRequestDTO request_dto){
    Optional<CategoryEntity> category_opt = entity_retriever.getCategoryByUuid(request_dto.getCategory_uuid());
    CategoryEntity category = null;
    if(category_opt.isPresent()) category = category_opt.get();

    TagEntity tag = entity_retriever.getTagByUuid(request_dto.getUuid()).get();
    String media_path = store_service.update(
      request_dto.getName(), 
      folder.name(), 
      request_dto.getImage(), 
      tag.getName()
    );
    return new TagUpdatePersistenceDTO(request_dto, category, media_path);
  }

  @Override
  public void delete(String uuid) {
    Optional<TagEntity> tag_opt = entity_retriever.getTagByUuid(uuid);
    if(tag_opt.isEmpty()) throw new EntityNotFoundException("Unable to find category with uuid");
    store_service.delete(
      tag_opt.get().getName(),
      folder.name()
    );
    super.delete(uuid);
  }

  public Page<TagReturnSimplifiedDTO> getTagsByCategory(Pageable pageable, String category_uuid) {
    CategoryEntity category = entity_retriever.getCategoryByUuid(category_uuid).get();
    Page<TagEntity> entities = this.repository.findAllByCategoryUuid(category.getId(), pageable);
    Page<TagReturnSimplifiedDTO> return_dto = entities.map(TagReturnSimplifiedDTO::new);
    return return_dto;
  }

}
