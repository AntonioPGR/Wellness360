package com.wellness360.nutrition.app.recipe;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wellness360.nutrition.app.category.CategoryEntity;
import com.wellness360.nutrition.app.recipe.dtos.RecipeCreateEntitiesDTO;
import com.wellness360.nutrition.app.recipe.dtos.RecipeCreateIdsDTO;
import com.wellness360.nutrition.app.recipe.dtos.RecipeReturnDTO;
import com.wellness360.nutrition.app.recipe.dtos.RecipeUpdateEntitiesDTO;
import com.wellness360.nutrition.app.recipe.dtos.RecipeUpdateIdsDTO;
import com.wellness360.nutrition.app.recipe.ingredient.IngredientService;
import com.wellness360.nutrition.app.recipe.media.MediaService;
import com.wellness360.nutrition.app.recipe.section.SectionService;
import com.wellness360.nutrition.app.tag.TagEntity;
import com.wellness360.nutrition.common.CrudBases.CrudService;
import com.wellness360.nutrition.tools.EntityRetrieverByUUID;

import jakarta.transaction.Transactional;


@Service
@Transactional
public class RecipeService extends CrudService<
  RecipeRepository, 
  RecipeCreateEntitiesDTO, 
  RecipeUpdateEntitiesDTO,
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
  EntityRetrieverByUUID uuid_getter;

  @Override
  public RecipeReturnDTO entityToReturnDTO(RecipeEntity entity) {
    return new RecipeReturnDTO(entity);
  }

  @Override
  public RecipeEntity createDTOtoEntity(RecipeCreateEntitiesDTO dto) {
    return new RecipeEntity(dto);
  }


  public RecipeReturnDTO create(RecipeCreateIdsDTO ids_dto) {
    TagEntity tag = uuid_getter.getTagByUuid(ids_dto.getTag_uuid());
    CategoryEntity category = uuid_getter.getCategoryByUuid(ids_dto.getCategory_uuid());

    RecipeCreateEntitiesDTO entities_dto = new RecipeCreateEntitiesDTO(ids_dto, tag, category);
    RecipeReturnDTO return_dto = super.create(entities_dto);
    RecipeEntity created_recipe = uuid_getter.getRecipeByUuid(return_dto.getUuid());
    
    section_service.createAll(ids_dto.getSections(), created_recipe);
    media_service.createAll(ids_dto.getMedia(), created_recipe);
    ingredient_service.createAll(ids_dto.getIngredients(), created_recipe);

    return return_dto;
  }


  public Optional<RecipeReturnDTO> update(RecipeUpdateIdsDTO ids_dto) {
    TagEntity tag = uuid_getter.getTagByUuid(ids_dto.getTag_uuid());
    CategoryEntity category = uuid_getter.getCategoryByUuid(ids_dto.getCategory_uuid());

    RecipeUpdateEntitiesDTO entities_dto = new RecipeUpdateEntitiesDTO(ids_dto, tag, category);
    Optional<RecipeReturnDTO> optional_dto = super.update(entities_dto);

    if(optional_dto.isEmpty()) return Optional.empty();
    RecipeReturnDTO return_dto = optional_dto.get();

    RecipeEntity recipe = uuid_getter.getRecipeByUuid(return_dto.getUuid());

    section_service.updateAll(ids_dto.getSections(), recipe);
    media_service.updateAll(ids_dto.getMedia(), recipe);
    ingredient_service.updateAll(ids_dto.getIngredients(), recipe);
    
    return Optional.of(return_dto);
  }

}
