package com.wellness360.nutrition.app.food;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wellness360.nutrition.app.category.CategoryEntity;
import com.wellness360.nutrition.app.category.CategoryService;
import com.wellness360.nutrition.app.food.dtos.FoodCreatePersistenceDTO;
import com.wellness360.nutrition.app.food.dtos.FoodCreateRequestDTO;
import com.wellness360.nutrition.app.food.dtos.FoodMapper;
import com.wellness360.nutrition.app.food.dtos.FoodNutrientsDTO;
import com.wellness360.nutrition.app.food.dtos.FoodReturnDTO;
import com.wellness360.nutrition.app.food.dtos.FoodUpdatePersistenceDTO;
import com.wellness360.nutrition.app.food.dtos.FoodUpdateRequestDTO;
import com.wellness360.nutrition.app.tag.TagEntity;
import com.wellness360.nutrition.app.tag.TagService;
import com.wellness360.nutrition.packages.storage.services.CrudStorageService;
import com.wellness360.nutrition.settings.storage.StorageFolders;


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
  TagService tag_service;

  @Autowired
  CategoryService category_service;

  public String getFolderName() {
    return StorageFolders.food.name();
  }

  public FoodReturnDTO getReturnDTO(FoodEntity entity) {
    return FoodMapper.INSTANCE.entityToReturn(entity);
  }

  public FoodEntity getEntity(FoodCreatePersistenceDTO dto) {
    return FoodMapper.INSTANCE.createPersistencetToEntity(dto);
  }

  public FoodCreatePersistenceDTO getPersistenceCreateDTO(FoodCreateRequestDTO dto, String image_url) {
    TagEntity tag_entity = tag_service.getEntityByUuid(dto.tag_uuid());
    CategoryEntity category_entity = category_service.getEntityByUuid(dto.category_uuid());
    FoodNutrientsDTO nutrients = new FoodNutrientsDTO(dto);
    return FoodMapper.INSTANCE.createRequestToPersistence(dto, nutrients, image_url, tag_entity, category_entity);
  }

  public FoodUpdatePersistenceDTO getPersistenceUpdateDTO(FoodUpdateRequestDTO dto, String image_url) {
    TagEntity tag_entity = dto.tag_uuid() != null? tag_service.getEntityByUuid(dto.tag_uuid()) : null;
    CategoryEntity category_entity = dto.category_uuid() != null? category_service.getEntityByUuid(dto.category_uuid()) : null;
    FoodNutrientsDTO nutrients = new FoodNutrientsDTO(dto);
    return FoodMapper.INSTANCE.updateRequestToPersistence(dto, nutrients, image_url, tag_entity, category_entity);
  }


}
