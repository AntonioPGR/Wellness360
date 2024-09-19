package com.wellness360.nutrition.app.tag;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.wellness360.nutrition.app.category.CategoryEntity;
import com.wellness360.nutrition.app.category.CategoryService;
import com.wellness360.nutrition.app.tag.dtos.TagCreatePersistenceDTO;
import com.wellness360.nutrition.app.tag.dtos.TagCreateRequestDTO;
import com.wellness360.nutrition.app.tag.dtos.TagMapper;
import com.wellness360.nutrition.app.tag.dtos.TagReturnCompleteDTO;
import com.wellness360.nutrition.app.tag.dtos.TagReturnSimplifiedDTO;
import com.wellness360.nutrition.app.tag.dtos.TagUpdatePersistenceDTO;
import com.wellness360.nutrition.app.tag.dtos.TagUpdateRequestDTO;
import com.wellness360.nutrition.packages.storage.services.CrudStorageService;
import com.wellness360.nutrition.settings.storage.StorageFolders;
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
  CategoryService category_service;

  public String getFolderName() {
    return StorageFolders.tag.name();
  }

  public Page<TagReturnSimplifiedDTO> getTagsByCategory(Pageable pageable, String category_uuid) {
    CategoryEntity category = category_service.getEntityByUuid(category_uuid);
    Page<TagEntity> entities = repository.findAllByCategoryUuid(category.getId(), pageable);
    return entities.map(
      (tag) -> TagMapper.INSTANCE.entityToReturnSimplified(tag)
    );
  }

  public TagEntity getEntity(TagCreatePersistenceDTO dto) {
    return TagMapper.INSTANCE.createPersistenceToEntity(dto);
  }

  public TagReturnCompleteDTO getReturnDTO(TagEntity entity) {
    return TagMapper.INSTANCE.entityToReturn(entity);
  }

  public TagCreatePersistenceDTO getPersistenceCreateDTO(TagCreateRequestDTO dto, String image_url){
    CategoryEntity category = category_service.getEntityByUuid(dto.category_uuid());
    return TagMapper.INSTANCE.createRequestToPersistence(dto, image_url, category);
  }

  public TagUpdatePersistenceDTO getPersistenceUpdateDTO(TagUpdateRequestDTO dto, String image_url){
    CategoryEntity category = dto.category_uuid() != null? category_service.getEntityByUuid(dto.category_uuid()) : null;
    return TagMapper.INSTANCE.updateRequestToPersistence(dto, image_url, category);
  }

}
