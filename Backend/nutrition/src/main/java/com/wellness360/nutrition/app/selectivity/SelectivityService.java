package com.wellness360.nutrition.app.selectivity;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.wellness360.nutrition.app.category.CategoryEntity;
import com.wellness360.nutrition.app.category.CategoryService;
import com.wellness360.nutrition.app.food.FoodEntity;
import com.wellness360.nutrition.app.food.FoodService;
import com.wellness360.nutrition.app.recipe.RecipeEntity;
import com.wellness360.nutrition.app.recipe.RecipeService;
import com.wellness360.nutrition.app.selectivity.dtos.SelectivityCreatePersistenceDTO;
import com.wellness360.nutrition.app.selectivity.dtos.SelectivityCreateRequestDTO;
import com.wellness360.nutrition.app.selectivity.dtos.SelectivityMapper;
import com.wellness360.nutrition.app.selectivity.dtos.SelectivityReturnDTO;
import com.wellness360.nutrition.validation.Validator;

import jakarta.transaction.Transactional;

@Transactional
public abstract class SelectivityService<
  Entity extends SelectivityBaseEntity
>{
  
  @Autowired
  SelectivityRepository<Entity> repository;

  @Autowired
  RecipeService recipe_service;
  @Autowired
  FoodService food_service;
  @Autowired
  CategoryService category_service;

  @Autowired
  Validator validate_service;

  public abstract Entity createDTOtoEntity(SelectivityCreatePersistenceDTO dto);
  public abstract SelectivityReturnDTO entityToReturnDTO(Entity entity);

  public List<SelectivityReturnDTO> getByUserUuid(String uuid) {
    List<Entity> entities_list = repository.findAllByUuid(uuid);
    return entities_list.stream().map((entity) -> SelectivityMapper.INSTANCE.entityToReturn(entity)).toList();
  }

  public SelectivityReturnDTO create(SelectivityCreateRequestDTO dto) {
    dto.validate(validate_service);
    RecipeEntity recipe = dto.recipe_uuid() != null? recipe_service.getEntityByUuid(dto.recipe_uuid()) : null;
    FoodEntity food = dto.food_uuid() != null? food_service.getEntityByUuid(dto.food_uuid()) : null;
    CategoryEntity category = dto.category_uuid() != null? category_service.getEntityByUuid(dto.category_uuid()) : null;
    SelectivityCreatePersistenceDTO entities_dto = SelectivityMapper.INSTANCE.createRequestToPersistence(1234L, recipe, food, category);
    Entity entity = createDTOtoEntity(entities_dto);
    entity = repository.save(entity);

    return entityToReturnDTO(entity);
  }

  public void deleteByUuid(String uuid) {
    repository.deleteByUuid(uuid);
  }

}
