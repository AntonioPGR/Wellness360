package com.wellness360.nutrition.app.recipe;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wellness360.nutrition.app.category.CategoryEntity;
import com.wellness360.nutrition.app.food.FoodEntity;
import com.wellness360.nutrition.app.recipe.dtos.RecipeCreatePersistenceDTO;
import com.wellness360.nutrition.app.recipe.dtos.RecipeCreateRequestDTO;
import com.wellness360.nutrition.app.recipe.dtos.RecipeReturnDTO;
import com.wellness360.nutrition.app.recipe.dtos.RecipeUpdatePersistenceDTO;
import com.wellness360.nutrition.app.recipe.dtos.RecipeUpdateRequestDTO;
import com.wellness360.nutrition.app.recipe.ingredient.IngredientService;
import com.wellness360.nutrition.app.recipe.media.MediaService;
import com.wellness360.nutrition.app.recipe.section.SectionService;
import com.wellness360.nutrition.app.tag.TagEntity;
import com.wellness360.nutrition.common.crud_bases.CrudService;
import com.wellness360.nutrition.tools.EntityRetrieverByUUID;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;


@Service
@Transactional
public class RecipeService extends CrudService<
  RecipeRepository, 
  RecipeCreateRequestDTO,
  RecipeCreatePersistenceDTO,
  RecipeUpdateRequestDTO,
  RecipeUpdatePersistenceDTO,
  RecipeReturnDTO,
  RecipeEntity
>{

  @Autowired
  SectionService section_service;
  @Autowired
  MediaService media_service;
  @Autowired
  IngredientService ingredient_service;
  @Autowired 
  EntityRetrieverByUUID entity_retriever;

  public RecipeReturnDTO getReturnDTO(RecipeEntity entity) {
    return new RecipeReturnDTO(entity);
  }

  public RecipeEntity getEntity(RecipeCreatePersistenceDTO dto) {
    return new RecipeEntity(dto);
  }

  public RecipeCreatePersistenceDTO getPersistenceCreateDTO(RecipeCreateRequestDTO request_dto) {
    Optional<TagEntity> tag_opt = entity_retriever.getTagByUuid(request_dto.getTag_uuid());
    if(tag_opt.isEmpty()) throw new EntityNotFoundException("Could not found tag");
    TagEntity tag = tag_opt.get();

    Optional<CategoryEntity> category_opt = entity_retriever.getCategoryByUuid(request_dto.getCategory_uuid());
    if(category_opt.isEmpty()) throw new EntityNotFoundException("Could not found category");
    CategoryEntity category = category_opt.get();

    return new RecipeCreatePersistenceDTO(request_dto, tag, category);
  }

  public RecipeUpdatePersistenceDTO getPersistenceUpdateDTO(RecipeUpdateRequestDTO request_dto) {
    Optional<TagEntity> tag_opt = entity_retriever.getTagByUuid(request_dto.getTag_uuid());
    TagEntity tag = null;
    if(tag_opt.isPresent()) tag = tag_opt.get();

    Optional<CategoryEntity> category_opt = entity_retriever.getCategoryByUuid(request_dto.getCategory_uuid());
    CategoryEntity category = null;
    if(category_opt.isPresent()) category = category_opt.get();

    return new RecipeUpdatePersistenceDTO(request_dto, tag, category);
  }

  // Override
  @Override
  public RecipeReturnDTO create(RecipeCreateRequestDTO request_dto) {
    RecipeReturnDTO return_dto = super.create(request_dto);
    RecipeEntity created_recipe = entity_retriever.getRecipeByUuid(return_dto.getUuid()).get();

    section_service.createAll(request_dto.getSections(), created_recipe);
    media_service.createAll(request_dto.getMedia(), created_recipe);
    ingredient_service.createAll(request_dto.getIngredients(), created_recipe);

    return new RecipeReturnDTO(created_recipe);
  }

  @Override
  public Optional<RecipeReturnDTO> update(RecipeUpdateRequestDTO request_dto) {
    Optional<RecipeEntity> old_entity_opt = entity_retriever.getRecipeByUuid(request_dto.getUuid());
    if(old_entity_opt.isEmpty()) return Optional.empty();
    RecipeEntity old_recipe = old_entity_opt.get();

    String old_name = old_recipe.getName();

    Optional<RecipeReturnDTO> opt_return_dto = super.update(request_dto);
    
    if(opt_return_dto.isEmpty()) return Optional.empty();

    RecipeReturnDTO return_dto = opt_return_dto.get();
    RecipeEntity recipe = entity_retriever.getRecipeByUuid(return_dto.getUuid()).get();

    if(request_dto.getSections() != null) section_service.updateAll(request_dto.getSections(), recipe);
    if(request_dto.getMedia() != null) media_service.updateAll(request_dto.getMedia(), recipe, old_name);
    if(request_dto.getIngredients() != null) ingredient_service.updateAll(request_dto.getIngredients(), recipe);

    return opt_return_dto;
  }

  @Override
  public void delete(String uuid) {
    Optional<RecipeEntity> recipe_entity_opt = entity_retriever.getRecipeByUuid(uuid);
    if(recipe_entity_opt.isEmpty()) throw new EntityNotFoundException("Unable to find category with uuid");
    RecipeEntity recipe = recipe_entity_opt.get();
    media_service.delete(
      recipe.getName(),
      recipe.getMedia().size()
    );
    super.delete(uuid);
  }

}
