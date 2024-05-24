package com.wellness360.nutrition.app.category;

import com.wellness360.nutrition.app.category.dtos.*;
import com.wellness360.nutrition.common.services.CrudStorageService;
import com.wellness360.nutrition.common.services.StorageEntityFileService;
import com.wellness360.nutrition.common.tools.EntityRetrieverByUUID;
import com.wellness360.nutrition.configurations.StorageFolders;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class CategoryService extends CrudStorageService<
  CategoryRepository,
  CategoryCreateRequestDTO,
  CategoryCreatePersistenceDTO,
  CategoryUpdateRequestDTO,
  CategoryUpdatePersistenceDTO,
  CategoryReturnDTO,
  CategoryEntity
> {

  @Autowired
  StorageEntityFileService store_service;
  @Autowired
  EntityRetrieverByUUID entity_retriever;

  public CategoryService() {
    super(StorageFolders.category.name());
  }

  // INHERIT
  public CategoryReturnDTO getReturnDTO(CategoryEntity entity) {
    return new CategoryReturnDTO(entity);
  }

  public CategoryEntity getEntity(CategoryCreatePersistenceDTO dto) {
    return new CategoryEntity(dto);
  }

  public CategoryCreatePersistenceDTO getPersistenceCreateDTO(CategoryCreateRequestDTO request_dto) {
    String image_path = store_service.create(
      request_dto.getName(),
      folder_name,
      request_dto.getImage()
    );
    return new CategoryCreatePersistenceDTO(request_dto, image_path);
  }

  public CategoryUpdatePersistenceDTO getPersistenceUpdateDTO(CategoryUpdateRequestDTO request_dto) {
    CategoryEntity category = getEntityByUuid(request_dto.getUuid())
      .orElseThrow(() -> new EntityNotFoundException("Could not find category with passed uuid"));
    String image_path = store_service.update(
      request_dto.getName(),
      folder_name,
      request_dto.getImage(),
      category.getName()
    );
    return new CategoryUpdatePersistenceDTO(request_dto, image_path);
  }

}
