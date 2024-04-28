package com.wellness360.nutrition.food;

import java.net.URI;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.wellness360.common.services.FullCrudService;
import com.wellness360.nutrition.category.CategoryEntity;
import com.wellness360.nutrition.category.CategoryRepository;
import com.wellness360.nutrition.food.dtos.FoodCreateEntitiesDTO;
import com.wellness360.nutrition.food.dtos.FoodCreateIdsDTO;
import com.wellness360.nutrition.food.dtos.FoodReturnDTO;
import com.wellness360.nutrition.food.dtos.FoodUpdateEntitiesDTO;
import com.wellness360.nutrition.food.dtos.FoodUpdateIdsDTO;
import com.wellness360.nutrition.tag.TagEntity;
import com.wellness360.nutrition.tag.TagRepository;

@Service
public class FoodService extends FullCrudService<
  FoodRepository,
  FoodCreateEntitiesDTO,
  FoodUpdateEntitiesDTO,
  FoodReturnDTO,
  FoodEntity
> {

  @Value("${url.food}")
  String default_url;
  @Autowired 
  TagRepository tag_repository;
  @Autowired 
  CategoryRepository category_repository;

  // INHERIT
  @Override
  protected FoodReturnDTO createReturnDTO(FoodEntity entity) {
    return new FoodReturnDTO(entity);
  }
  @Override
  protected FoodEntity createEntity(FoodCreateEntitiesDTO dto) {
    return new FoodEntity(dto);
  }
  @Override
  protected String getReturnURL(String uuid) {
    return default_url + "/" + uuid;
  }

  // ID to ENTITY dtos
  public Optional<URI> create(FoodCreateIdsDTO ids_dto) {
    String tag_id = ids_dto.getTag_uuid();
    Optional<TagEntity> tag_optional = tag_repository.findByUuid(tag_id);
    TagEntity tag_entity = tag_optional.isPresent()? tag_optional.get() : null;

    System.out.println(ids_dto.getCategory_uuid());

    String category_id = ids_dto.getCategory_uuid();
    Optional<CategoryEntity> category_optional = category_repository.findByUuid(category_id);
    CategoryEntity category_entity = category_optional.isPresent()? category_optional.get() : null;

    FoodCreateEntitiesDTO entity_dto = new FoodCreateEntitiesDTO(ids_dto, tag_entity, category_entity);
    return super.create(entity_dto);
  }

  public Optional<FoodReturnDTO> update(FoodUpdateIdsDTO ids_dto) {
    String tag_id = ids_dto.getTag_uuid();
    TagEntity tag_entity = null;
    if(tag_id != null){
      Optional<TagEntity> tag_optional = tag_repository.findByUuid(tag_id);
      tag_entity = tag_optional.isPresent()? tag_optional.get() : null;
    }

    String category_id = ids_dto.getCategory_uuid();
    CategoryEntity category_entity = null;
    if(category_id != null){
      Optional<CategoryEntity> category_optional = category_repository.findByUuid(category_id);
      category_entity = category_optional.isPresent()? category_optional.get() : null;
    }

    FoodUpdateEntitiesDTO entity_dto = new FoodUpdateEntitiesDTO(ids_dto, tag_entity, category_entity);
    return super.update(entity_dto);
  }

}
