package com.wellness360.nutrition.app.selectivity;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.wellness360.nutrition.app.category.CategoryEntity;
import com.wellness360.nutrition.app.category.CategoryRepository;
import com.wellness360.nutrition.app.food.FoodEntity;
import com.wellness360.nutrition.app.food.FoodRepository;
import com.wellness360.nutrition.app.recipe.RecipeEntity;
import com.wellness360.nutrition.app.recipe.RecipeRepository;
import com.wellness360.nutrition.app.selectivity.dtos.SelectivityCreatePersistenceDTO;
import com.wellness360.nutrition.app.selectivity.dtos.SelectivityCreateRequestDTO;
import com.wellness360.nutrition.app.selectivity.dtos.SelectivityReturnDTO;
import com.wellness360.nutrition.common.services.ValidateService;

import jakarta.transaction.Transactional;

@Transactional
public abstract class SelectivityService<
  Entity extends SelectivityBaseEntity
>{
  
  @Autowired
  SelectivityRepository<Entity> repository;

  @Autowired
  RecipeRepository recipe_repository;
  @Autowired
  FoodRepository food_repository;
  @Autowired
  CategoryRepository category_repository;

  @Autowired
  ValidateService validate_service;

  public abstract Entity createDTOtoEntity(SelectivityCreatePersistenceDTO dto);
  public abstract SelectivityReturnDTO entityToReturnDTO(Entity entity);

  public List<SelectivityReturnDTO> getByUserUuid(String uuid) {
    List<Entity> entities_list = repository.findAllByUserId(1L);
    return entities_list.stream().map(SelectivityReturnDTO::new).toList();
  }

  public SelectivityReturnDTO create(SelectivityCreateRequestDTO id_dto) {
    id_dto.validate(validate_service);

    RecipeEntity recipe = recipe_repository.findByUuid(id_dto.getRecipe_uuid())
      .orElse(null);

    FoodEntity food = food_repository.findByUuid(id_dto.getFood_uuid())
      .orElse(null);

    CategoryEntity category = category_repository.findByUuid(id_dto.getCategory_uuid())
      .orElse(null);

    SelectivityCreatePersistenceDTO entities_dto = new SelectivityCreatePersistenceDTO(1L, recipe, food, category);
    Entity entity = createDTOtoEntity(entities_dto);
    entity = repository.save(entity);

    return entityToReturnDTO(entity);
  }

  public void deleteByUuid(String uuid) {
    repository.deleteByUuid(uuid);
  }

}
