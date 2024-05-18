package com.wellness360.nutrition.app.recipe.ingredient;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wellness360.nutrition.app.food.FoodEntity;
import com.wellness360.nutrition.app.recipe.RecipeEntity;
import com.wellness360.nutrition.app.recipe.ingredient.dto.IngredientCreatePersistenceDTO;
import com.wellness360.nutrition.app.recipe.ingredient.dto.IngredientCreateRequestDTO;
import com.wellness360.nutrition.app.recipe.ingredient.dto.IngredientReturnDTO;
import com.wellness360.nutrition.app.recipe.ingredient.dto.IngredientUpdatePersistenceDTO;
import com.wellness360.nutrition.app.recipe.ingredient.dto.IngredientUpdateRequestDTO;
import com.wellness360.nutrition.tools.EntityRetrieverByUUID;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class IngredientService{

  @Autowired
  IngredientRepository repository;
  @Autowired
  EntityRetrieverByUUID uuid_getter;
  
  public void createAll(List<IngredientCreateRequestDTO> dto_list, RecipeEntity recipe){
    dto_list.stream().forEach((dto) -> create(dto, recipe));
  }
  public IngredientReturnDTO create(IngredientCreateRequestDTO dto, RecipeEntity recipe){
    Optional<FoodEntity> food_opt = uuid_getter.getFoodByUuid(dto.getFood_uuid());
    if(food_opt.isEmpty()) throw new EntityNotFoundException("Could not found food for ingredient");
    FoodEntity food = food_opt.get();
    IngredientCreatePersistenceDTO create_dto = new IngredientCreatePersistenceDTO(dto, food, recipe);
    IngredientEntity entity = new IngredientEntity(create_dto);
    repository.save(entity);
    return new IngredientReturnDTO(entity);
  }

  public void updateAll(List<IngredientUpdateRequestDTO> dto_list, RecipeEntity recipe) {
    dto_list.stream().forEach((dto) -> update(dto, recipe));
  }
  public Optional<IngredientReturnDTO> update(IngredientUpdateRequestDTO dto, RecipeEntity recipe){
    FoodEntity food = uuid_getter.getFoodByUuid(dto.getFood_uuid()).get();
    IngredientUpdatePersistenceDTO update_dto = new IngredientUpdatePersistenceDTO(dto, food, recipe);
    Optional<IngredientEntity> opt_entity = repository.findByUuid(dto.getUuid());
    if(opt_entity == null) return Optional.empty();
    IngredientEntity entity = opt_entity.get();
    entity.update(update_dto);
    return Optional.of(new IngredientReturnDTO(entity));
  }

}
