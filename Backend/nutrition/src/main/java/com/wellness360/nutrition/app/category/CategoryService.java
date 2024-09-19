package com.wellness360.nutrition.app.category;

import com.wellness360.nutrition.app.category.dtos.*;
import com.wellness360.nutrition.packages.storage.services.CrudStorageService;
import com.wellness360.nutrition.settings.storage.StorageFolders;

import org.springframework.stereotype.Service;

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

  public String getFolderName() {
    return StorageFolders.category.name();
  }

  public CategoryReturnDTO getReturnDTO(CategoryEntity entity) {
    return CategoryMapper.INSTANCE.entityToReturn(entity);
  }

  public CategoryEntity getEntity(CategoryCreatePersistenceDTO dto) {
    return CategoryMapper.INSTANCE.createPersistenceToEntity(dto);
  }

  public CategoryCreatePersistenceDTO getPersistenceCreateDTO(CategoryCreateRequestDTO dto, String image_url) {
    return CategoryMapper.INSTANCE.createRequestToPersistence(dto, image_url);
  }

  public CategoryUpdatePersistenceDTO getPersistenceUpdateDTO(CategoryUpdateRequestDTO dto, String image_url) {
    return CategoryMapper.INSTANCE.updateRequestToPersistence(dto, image_url);
  }


}
