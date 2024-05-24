package com.wellness360.nutrition.app.food;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wellness360.nutrition.app.category.CategoryEntity;
import com.wellness360.nutrition.app.food.dtos.FoodCreatePersistenceDTO;
import com.wellness360.nutrition.app.food.dtos.FoodCreateRequestDTO;
import com.wellness360.nutrition.app.food.dtos.FoodReturnDTO;
import com.wellness360.nutrition.app.food.dtos.FoodUpdatePersistenceDTO;
import com.wellness360.nutrition.app.food.dtos.FoodUpdateRequestDTO;
import com.wellness360.nutrition.app.tag.TagEntity;
import com.wellness360.nutrition.common.services.CrudStorageService;
import com.wellness360.nutrition.common.services.StorageEntityFileService;
import com.wellness360.nutrition.common.tools.EntityRetrieverByUUID;
import com.wellness360.nutrition.configurations.StorageFolders;


@Service
public class FoodService extends CrudStorageService<
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
  
  public FoodService(String tag) {
    super(StorageFolders.food.name());
  }

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
      folder_name, 
      request_dto.getImage()
    );
    return new FoodCreatePersistenceDTO(request_dto, image_url, tag_entity, category_entity);
  }

  public FoodUpdatePersistenceDTO getPersistenceUpdateDTO(FoodUpdateRequestDTO request_dto) {
    TagEntity tag_entity = entity_retriever.getTagByUuid(request_dto.getTag_uuid()).orElse(null);
    CategoryEntity category_entity = entity_retriever.getCategoryByUuid(request_dto.getCategory_uuid()).orElse(null);

    FoodEntity food = entity_retriever.getFoodByUuid(request_dto.getUuid()).get();
    String media_path = store_service.update(
      request_dto.getName(), 
      folder_name, 
      request_dto.getImage(), 
      food.getName()
    );
    return new FoodUpdatePersistenceDTO(request_dto, media_path, tag_entity, category_entity);
  }

}
