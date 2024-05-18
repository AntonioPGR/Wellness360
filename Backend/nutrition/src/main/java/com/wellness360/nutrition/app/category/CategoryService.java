package com.wellness360.nutrition.app.category;

import com.wellness360.nutrition.app.category.dtos.*;
import com.wellness360.nutrition.common.crud_bases.CrudService;
import com.wellness360.nutrition.common.media_storage.StorageEntityFileService;
import com.wellness360.nutrition.common.media_storage.StorageFolders;
import com.wellness360.nutrition.tools.EntityRetrieverByUUID;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class CategoryService extends CrudService<
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
  StorageFolders folder = StorageFolders.category;

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
      folder.name(),
      request_dto.getImage()
    );
    return new CategoryCreatePersistenceDTO(request_dto, image_path);
  }

  public CategoryUpdatePersistenceDTO getPersistenceUpdateDTO(CategoryUpdateRequestDTO request_dto) {
    CategoryEntity category = entity_retriever.getCategoryByUuid(request_dto.getUuid()).get();
    String image_path = store_service.update(
      request_dto.getName(),
      folder.name(),
      request_dto.getImage(),
      category.getName()
    );
    return new CategoryUpdatePersistenceDTO(request_dto, image_path);
  }

  @Override
  public void delete(String uuid) {
    Optional<CategoryEntity> category_opt = entity_retriever.getCategoryByUuid(uuid);
    if(category_opt.isEmpty()) throw new EntityNotFoundException("Unable to find category with uuid");
    store_service.delete(
      category_opt.get().getName(),
      folder.name()
    );
    super.delete(uuid);
  }

}
