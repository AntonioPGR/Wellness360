package com.wellness360.nutrition.app.selectivity;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.wellness360.nutrition.app.category.CategoryEntity;
import com.wellness360.nutrition.app.category.CategoryRepository;
import com.wellness360.nutrition.app.food.FoodEntity;
import com.wellness360.nutrition.app.food.FoodRepository;
import com.wellness360.nutrition.app.recipe.RecipeEntity;
import com.wellness360.nutrition.app.recipe.RecipeRepository;
import com.wellness360.nutrition.app.selectivity.dtos.SelectivityCreateEntitiesDTO;
import com.wellness360.nutrition.app.selectivity.dtos.SelectivityCreateIdsDTO;
import com.wellness360.nutrition.app.selectivity.dtos.SelectivityReturnDTO;

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

  public abstract Entity createDTOtoEntity(SelectivityCreateEntitiesDTO dto);
  public abstract SelectivityReturnDTO entityToReturnDTO(Entity entity);

  public List<SelectivityReturnDTO> getByUserUuid(String uuid) {
    List<Entity> entities_list = repository.findAllByUserId(1L);
    return entities_list.stream().map(SelectivityReturnDTO::new).toList();
  }

  public SelectivityReturnDTO create(SelectivityCreateIdsDTO id_dto) {
    Optional<RecipeEntity> recipe_opt = recipe_repository.findByUuid(id_dto.getRecipe_uuid());
    RecipeEntity recipe = recipe_opt.isPresent()? recipe_opt.get() : null;

    Optional<FoodEntity> food_opt = food_repository.findByUuid(id_dto.getFood_uuid());
    FoodEntity food = food_opt.isPresent()? food_opt.get() : null;

    Optional<CategoryEntity> category_opt = category_repository.findByUuid(id_dto.getCategory_uuid());
    CategoryEntity category = category_opt.isPresent()? category_opt.get() : null;

    SelectivityCreateEntitiesDTO entities_dto = new SelectivityCreateEntitiesDTO(1L, recipe, food, category);
    Entity entity = createDTOtoEntity(entities_dto);
    entity = repository.save(entity);

    return entityToReturnDTO(entity);
  }

  public void deleteByUuid(String uuid) {
    repository.deleteByUuid(uuid);
  }

}
