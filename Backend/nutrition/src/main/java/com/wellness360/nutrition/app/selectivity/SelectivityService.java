package com.wellness360.nutrition.app.selectivity;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;

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

  public abstract Entity persistenceToEntity(SelectivityCreatePersistenceDTO dto);

  public List<SelectivityReturnDTO> getByUserUuid() {
    String user_uuid = getUserUuid();
    List<Entity> entities_list = repository.findAllByUserUuid(user_uuid);
    return entities_list.stream().map((entity) -> SelectivityMapper.INSTANCE.entityToReturn(entity)).toList();
  }

  public SelectivityReturnDTO create(SelectivityCreateRequestDTO dto) {
    dto.validate(validate_service);

    RecipeEntity recipe = dto.recipe_uuid() != null? recipe_service.getEntityByUuid(dto.recipe_uuid()) : null;
    FoodEntity food = dto.food_uuid() != null? food_service.getEntityByUuid(dto.food_uuid()) : null;
    CategoryEntity category = dto.category_uuid() != null? category_service.getEntityByUuid(dto.category_uuid()) : null;
    String user_uuid = getUserUuid();

    SelectivityCreatePersistenceDTO entities_dto = SelectivityMapper.INSTANCE.createRequestToPersistence(user_uuid, recipe, food, category);
    Entity entity = persistenceToEntity(entities_dto);
    entity = repository.save(entity);

    return SelectivityMapper.INSTANCE.entityToReturn(entity);
  }

  public void deleteByUuid(String uuid) {
    repository.deleteByUuid(uuid);
  }

  private String getUserUuid(){
    return (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
  }

}
