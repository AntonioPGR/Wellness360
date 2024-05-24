package com.wellness360.nutrition.app.recipe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wellness360.nutrition.app.category.CategoryEntity;
import com.wellness360.nutrition.app.recipe.dtos.RecipeCreatePersistenceDTO;
import com.wellness360.nutrition.app.recipe.dtos.RecipeCreateRequestDTO;
import com.wellness360.nutrition.app.recipe.dtos.RecipeReturnDTO;
import com.wellness360.nutrition.app.recipe.dtos.RecipeUpdatePersistenceDTO;
import com.wellness360.nutrition.app.recipe.dtos.RecipeUpdateRequestDTO;
import com.wellness360.nutrition.app.recipe.ingredient.IngredientService;
import com.wellness360.nutrition.app.recipe.media.MediaService;
import com.wellness360.nutrition.app.recipe.section.SectionService;
import com.wellness360.nutrition.app.tag.TagEntity;
import com.wellness360.nutrition.common.services.CrudService;
import com.wellness360.nutrition.common.tools.EntityRetrieverByUUID;

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
    TagEntity tag = entity_retriever.getTagByUuid(request_dto.getTag_uuid())
      .orElseThrow(() -> new EntityNotFoundException("Could not found tag"));

    CategoryEntity category = entity_retriever.getCategoryByUuid(request_dto.getCategory_uuid())
      .orElseThrow(() -> new EntityNotFoundException("Could not found category"));

    return new RecipeCreatePersistenceDTO(request_dto, tag, category);
  }

  public RecipeUpdatePersistenceDTO getPersistenceUpdateDTO(RecipeUpdateRequestDTO request_dto) {
    TagEntity tag = entity_retriever.getTagByUuid(request_dto.getTag_uuid())
      .orElse(null);

    CategoryEntity category = entity_retriever.getCategoryByUuid(request_dto.getCategory_uuid())
      .orElse(null);

    return new RecipeUpdatePersistenceDTO(request_dto, tag, category);
  }

  // Override
  @Override
  public RecipeReturnDTO create(RecipeCreateRequestDTO request_dto) {
    RecipeReturnDTO return_dto = super.create(request_dto);
    RecipeEntity created_recipe = getEntityByUuid(return_dto.getUuid()).get();

    section_service.createAll(request_dto.getSections(), created_recipe);
    media_service.createAll(request_dto.getMedia(), created_recipe);
    ingredient_service.createAll(request_dto.getIngredients(), created_recipe);

    return new RecipeReturnDTO(created_recipe);
  }

  @Override
  public RecipeReturnDTO update(RecipeUpdateRequestDTO request_dto) {
    RecipeEntity old_recipe = entity_retriever.getRecipeByUuid(request_dto.getUuid())
      .orElseThrow(() -> new EntityNotFoundException("Unable to find recipe with passed uuid"));

    String old_name = old_recipe.getName();

    RecipeReturnDTO return_dto = super.update(request_dto);
    RecipeEntity recipe = entity_retriever.getRecipeByUuid(return_dto.getUuid()).get();

    if(request_dto.getSections() != null) section_service.updateAll(request_dto.getSections(), recipe);
    if(request_dto.getMedia() != null) media_service.updateAll(request_dto.getMedia(), recipe, old_name);
    if(request_dto.getIngredients() != null) ingredient_service.updateAll(request_dto.getIngredients(), recipe);

    return return_dto;
  }

  @Override
  public void delete(String uuid) {
    RecipeEntity recipe = entity_retriever.getRecipeByUuid(uuid)
      .orElseThrow(() -> new EntityNotFoundException("Unable to find recipe with uuid"));
    media_service.delete(
      recipe.getName(),
      recipe.getMedia().size()
    );
    super.delete(uuid);
  }

}
