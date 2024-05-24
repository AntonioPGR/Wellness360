package com.wellness360.nutrition.app.tag;



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
import com.wellness360.nutrition.common.services.CrudStorageService;
import com.wellness360.nutrition.common.services.StorageEntityFileService;
import com.wellness360.nutrition.common.tools.EntityRetrieverByUUID;
import com.wellness360.nutrition.configurations.StorageFolders;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class TagService extends CrudStorageService<
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

  public TagService(){
    super(StorageFolders.tag.name());
  }

  public Page<TagReturnSimplifiedDTO> getTagsByCategory(Pageable pageable, String category_uuid) {
    CategoryEntity category = entity_retriever.getCategoryByUuid(category_uuid).get();
    Page<TagEntity> entities = this.repository.findAllByCategoryUuid(category.getId(), pageable);
    Page<TagReturnSimplifiedDTO> return_dto = entities.map(TagReturnSimplifiedDTO::new);
    return return_dto;
  }

  // INHERIT
  public TagReturnCompleteDTO getReturnDTO(TagEntity entity) {
    return new TagReturnCompleteDTO(entity);
  }

  public TagEntity getEntity(TagCreatePersistenceDTO dto) {
    return new TagEntity(dto);
  }

  public TagCreatePersistenceDTO getPersistenceCreateDTO(TagCreateRequestDTO request_dto){
    CategoryEntity category = entity_retriever.getCategoryByUuid(request_dto.getCategory_uuid()).get();

    String media_path = store_service.create(
      request_dto.getName(), 
      folder_name, 
      request_dto.getImage()
    );
    return new TagCreatePersistenceDTO(request_dto, media_path, category);
  }

  public TagUpdatePersistenceDTO getPersistenceUpdateDTO(TagUpdateRequestDTO request_dto){
    CategoryEntity category = entity_retriever.getCategoryByUuid(request_dto.getCategory_uuid())
      .orElse(null);

    TagEntity tag = entity_retriever.getTagByUuid(request_dto.getUuid()).get();
    String media_path = store_service.update(
      request_dto.getName(), 
      folder_name, 
      request_dto.getImage(), 
      tag.getName()
    );
    return new TagUpdatePersistenceDTO(request_dto, category, media_path);
  }
  
  public String getEntityName(TagEntity entity) {
    return entity.getName();
  }

}
