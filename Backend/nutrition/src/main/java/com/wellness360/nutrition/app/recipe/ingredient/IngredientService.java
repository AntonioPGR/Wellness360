package com.wellness360.nutrition.app.recipe.ingredient;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wellness360.nutrition.app.food.FoodEntity;
import com.wellness360.nutrition.app.recipe.RecipeEntity;
import com.wellness360.nutrition.app.recipe.ingredient.dto.IngredientCreateEntitiesDTO;
import com.wellness360.nutrition.app.recipe.ingredient.dto.IngredientCreateIdsDTO;
import com.wellness360.nutrition.app.recipe.ingredient.dto.IngredientReturnDTO;
import com.wellness360.nutrition.app.recipe.ingredient.dto.IngredientUpdateEntitiesDTO;
import com.wellness360.nutrition.app.recipe.ingredient.dto.IngredientUpdateIdsDTO;
import com.wellness360.nutrition.common.CrudBases.CrudService;
import com.wellness360.nutrition.tools.EntityRetrieverByUUID;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class IngredientService extends CrudService<
  IngredientRepository,
  IngredientCreateEntitiesDTO,
  IngredientUpdateEntitiesDTO,
  IngredientReturnDTO,
  IngredientEntity
>{

  @Autowired
  IngredientRepository repository;
  @Autowired
  EntityRetrieverByUUID uuid_getter;
  

  public void createAll(List<IngredientCreateIdsDTO> dto_list, RecipeEntity recipe){
    dto_list.stream().forEach((dto) -> create(dto, recipe));
  }

  public IngredientReturnDTO create(IngredientCreateIdsDTO dto, RecipeEntity recipe){
    FoodEntity food = uuid_getter.getFoodByUuid(dto.getFood_uuid());
    IngredientCreateEntitiesDTO create_dto = new IngredientCreateEntitiesDTO(dto, food, recipe);
    return super.create(create_dto);
  }

  public void updateAll(List<IngredientUpdateIdsDTO> dto_list, RecipeEntity recipe) {
    dto_list.stream().forEach((dto) -> update(dto, recipe));
  }

  public Optional<IngredientReturnDTO> update(IngredientUpdateIdsDTO dto, RecipeEntity recipe){
    FoodEntity food = uuid_getter.getFoodByUuid(dto.getFood_uuid());
    IngredientUpdateEntitiesDTO update_dto = new IngredientUpdateEntitiesDTO(dto, food, recipe);
    return super.update(update_dto);
  }

  // INHERIT
  @Override
  public IngredientReturnDTO entityToReturnDTO(IngredientEntity entity) {
    return new IngredientReturnDTO(entity);
  }

  @Override
  public IngredientEntity createDTOtoEntity(IngredientCreateEntitiesDTO dto) {
    return new IngredientEntity(dto);
  }

}
