package com.wellness360.nutrition.app.recipe.ingredient;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wellness360.nutrition.app.food.FoodEntity;
import com.wellness360.nutrition.app.food.FoodService;
import com.wellness360.nutrition.app.recipe.RecipeEntity;
import com.wellness360.nutrition.app.recipe.ingredient.dto.IngredientCreatePersistenceDTO;
import com.wellness360.nutrition.app.recipe.ingredient.dto.IngredientCreateRequestDTO;
import com.wellness360.nutrition.app.recipe.ingredient.dto.IngredientMapper;
import com.wellness360.nutrition.app.recipe.ingredient.dto.IngredientReturnDTO;
import com.wellness360.nutrition.app.recipe.ingredient.dto.IngredientUpdatePersistenceDTO;
import com.wellness360.nutrition.app.recipe.ingredient.dto.IngredientUpdateRequestDTO;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class IngredientService{

  @Autowired
  IngredientRepository repository;

  @Autowired
  FoodService food_service;
  
  public void createAll(List<IngredientCreateRequestDTO> dto_list, RecipeEntity recipe){
    dto_list.stream().forEach((dto) -> create(dto, recipe));
  }
  public IngredientReturnDTO create(IngredientCreateRequestDTO dto, RecipeEntity recipe){
    FoodEntity food = food_service.getEntityByUuid(dto.food_uuid());
    IngredientCreatePersistenceDTO create_dto = IngredientMapper.INSTANCE.createRequestToPersistence(dto, food, recipe);
    IngredientEntity entity = IngredientMapper.INSTANCE.createPersistenceToEntity(create_dto);
    repository.save(entity);
    return IngredientMapper.INSTANCE.entityToReturnDTO(entity);
  }

  public void updateAll(List<IngredientUpdateRequestDTO> dto_list, RecipeEntity recipe) {
    dto_list.stream().forEach((dto) -> update(dto, recipe));
  }
  public IngredientReturnDTO update(IngredientUpdateRequestDTO dto, RecipeEntity recipe){
    IngredientEntity entity = repository.findByUuid(dto.uuid())
      .orElseThrow(()->new EntityNotFoundException("Could not find ingredient with passed uuid"));
    FoodEntity food = food_service.getEntityByUuid(dto.food_uuid());
    IngredientUpdatePersistenceDTO update_dto = IngredientMapper.INSTANCE.updateRequestToPersistence(dto, food, recipe);
    entity.update(update_dto);
    return IngredientMapper.INSTANCE.entityToReturnDTO(entity);
  }

}
