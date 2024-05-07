package com.wellness360.nutrition.app.food;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wellness360.nutrition.app.category.CategoryEntity;
import com.wellness360.nutrition.app.food.dtos.FoodCreateEntitiesDTO;
import com.wellness360.nutrition.app.food.dtos.FoodCreateIdsDTO;
import com.wellness360.nutrition.app.food.dtos.FoodReturnDTO;
import com.wellness360.nutrition.app.food.dtos.FoodUpdateEntitiesDTO;
import com.wellness360.nutrition.app.food.dtos.FoodUpdateIdsDTO;
import com.wellness360.nutrition.app.tag.TagEntity;
import com.wellness360.nutrition.common.CrudBases.CrudService;
import com.wellness360.nutrition.tools.EntityRetrieverByUUID;

@Service
public class FoodService extends CrudService<
  FoodRepository,
  FoodCreateEntitiesDTO,
  FoodUpdateEntitiesDTO,
  FoodReturnDTO,
  FoodEntity
> {

  @Autowired 
  EntityRetrieverByUUID uuid_getter;

  // INHERIT
  @Override
  public FoodReturnDTO entityToReturnDTO(FoodEntity entity) {
    return new FoodReturnDTO(entity);
  }
  @Override
  public FoodEntity createDTOtoEntity(FoodCreateEntitiesDTO dto) {
    return new FoodEntity(dto);
  }

  // ID to ENTITY dtos
  public FoodReturnDTO create(FoodCreateIdsDTO ids_dto) {
    TagEntity tag_entity = uuid_getter.getTagByUuid(ids_dto.getTag_uuid());
    CategoryEntity category_entity = uuid_getter.getCategoryByUuid(ids_dto.getCategory_uuid());
    FoodCreateEntitiesDTO entity_dto = new FoodCreateEntitiesDTO(ids_dto, tag_entity, category_entity);
    return super.create(entity_dto);
  }

  public Optional<FoodReturnDTO> update(FoodUpdateIdsDTO ids_dto) {
    TagEntity tag_entity = uuid_getter.getTagByUuid(ids_dto.getTag_uuid());
    CategoryEntity category_entity = uuid_getter.getCategoryByUuid(ids_dto.getCategory_uuid());
    FoodUpdateEntitiesDTO entity_dto = new FoodUpdateEntitiesDTO(ids_dto, tag_entity, category_entity);
    return super.update(entity_dto);
  }

}
