package com.wellness360.nutrition.app.food;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wellness360.nutrition.app.category.CategoryEntity;
import com.wellness360.nutrition.app.food.dtos.FoodCreatePersistenceDTO;
import com.wellness360.nutrition.app.food.dtos.FoodCreateRequestDTO;
import com.wellness360.nutrition.app.food.dtos.FoodReturnDTO;
import com.wellness360.nutrition.app.food.dtos.FoodUpdatePersistenceDTO;
import com.wellness360.nutrition.app.food.dtos.FoodUpdateRequestDTO;
import com.wellness360.nutrition.app.tag.TagEntity;
import com.wellness360.nutrition.common.crud_bases.CrudService;
import com.wellness360.nutrition.common.media_storage.StorageEntityFileService;
import com.wellness360.nutrition.common.media_storage.StorageFolders;
import com.wellness360.nutrition.tools.EntityRetrieverByUUID;

import jakarta.persistence.EntityNotFoundException;


@Service
public class FoodService extends CrudService<
  FoodRepository,
  FoodCreateRequestDTO,
  FoodCreatePersistenceDTO,
  FoodUpdateRequestDTO,
  FoodUpdatePersistenceDTO,
  FoodReturnDTO,
  FoodEntity
> {

  @Autowired
  StorageEntityFileService store_service;
  @Autowired
  EntityRetrieverByUUID entity_retriever;
  
  StorageFolders folder = StorageFolders.food;

  // INHERIT
  public FoodReturnDTO getReturnDTO(FoodEntity entity) {
    return new FoodReturnDTO(entity);
  }
  public FoodEntity getEntity(FoodCreatePersistenceDTO dto) {
    return new FoodEntity(dto);
  }

  public FoodCreatePersistenceDTO getPersistenceCreateDTO(FoodCreateRequestDTO request_dto) {
    TagEntity tag_entity = entity_retriever.getTagByUuid(request_dto.getTag_uuid()).get();
    CategoryEntity category_entity = entity_retriever.getCategoryByUuid(request_dto.getCategory_uuid()).get();

    String image_url = store_service.create(
      request_dto.getName(), 
      folder.name(), 
      request_dto.getImage()
    );
    return new FoodCreatePersistenceDTO(request_dto, image_url, tag_entity, category_entity);
  }

  public FoodUpdatePersistenceDTO getPersistenceUpdateDTO(FoodUpdateRequestDTO request_dto) {
    Optional<TagEntity> tag_entity_opt = entity_retriever.getTagByUuid(request_dto.getTag_uuid());
    TagEntity tag_entity = null;
    if(tag_entity_opt.isPresent()) tag_entity = tag_entity_opt.get();

    Optional<CategoryEntity> category_entity_opt = entity_retriever.getCategoryByUuid(request_dto.getCategory_uuid());
    CategoryEntity category_entity = null;
    if(category_entity_opt.isPresent()) category_entity = category_entity_opt.get();

    FoodEntity food = entity_retriever.getFoodByUuid(request_dto.getUuid()).get();
    String media_path = store_service.update(
      request_dto.getName(), 
      folder.name(), 
      request_dto.getImage(), 
      food.getName()
    );
    return new FoodUpdatePersistenceDTO(request_dto, media_path, tag_entity, category_entity);
  }

  @Override
  public void delete(String uuid) {
    Optional<FoodEntity> food_entity_opt = entity_retriever.getFoodByUuid(uuid);
    if(food_entity_opt.isEmpty()) throw new EntityNotFoundException("Unable to find category with uuid");
    store_service.delete(
      food_entity_opt.get().getName(),
      folder.name()
    );
    super.delete(uuid);
  }

}
