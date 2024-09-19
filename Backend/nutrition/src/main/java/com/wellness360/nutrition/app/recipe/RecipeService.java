package com.wellness360.nutrition.app.recipe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wellness360.nutrition.app.category.CategoryEntity;
import com.wellness360.nutrition.app.category.CategoryService;
import com.wellness360.nutrition.app.recipe.dtos.RecipeCreatePersistenceDTO;
import com.wellness360.nutrition.app.recipe.dtos.RecipeCreateRequestDTO;
import com.wellness360.nutrition.app.recipe.dtos.RecipeMapper;
import com.wellness360.nutrition.app.recipe.dtos.RecipeReturnDTO;
import com.wellness360.nutrition.app.recipe.dtos.RecipeUpdatePersistenceDTO;
import com.wellness360.nutrition.app.recipe.dtos.RecipeUpdateRequestDTO;
import com.wellness360.nutrition.app.recipe.ingredient.IngredientService;
import com.wellness360.nutrition.app.recipe.media.MediaService;
import com.wellness360.nutrition.app.recipe.section.SectionService;
import com.wellness360.nutrition.app.tag.TagEntity;
import com.wellness360.nutrition.app.tag.TagService;
import com.wellness360.nutrition.packages.crud.service.CrudDtoTransformService;
import jakarta.transaction.Transactional;


@Service
@Transactional
public class RecipeService extends CrudDtoTransformService<
  RecipeRepository, 
  RecipeCreateRequestDTO,
  RecipeCreatePersistenceDTO,
  RecipeUpdateRequestDTO,
  RecipeUpdatePersistenceDTO,
  RecipeReturnDTO,
  RecipeEntity
>{

  @Autowired
  TagService tag_service;
  @Autowired
  CategoryService category_service;

  @Autowired
  SectionService section_service;
  @Autowired
  MediaService media_service;
  @Autowired
  IngredientService ingredient_service;

  public RecipeReturnDTO buildReturnDTO(RecipeEntity entity) {
    return RecipeMapper.INSTANCE.entityToReturn(entity);
  }

  public RecipeEntity getEntityByPersistenceDTO(RecipeCreatePersistenceDTO dto) {
    return RecipeMapper.INSTANCE.createPersistenceToEntity(dto);
  }

  public RecipeCreatePersistenceDTO getPersistenceCreateDTO(RecipeCreateRequestDTO request_dto) {
    TagEntity tag = tag_service.getEntityByUuid(request_dto.tag_uuid());
    CategoryEntity category = category_service.getEntityByUuid(request_dto.category_uuid());
    return RecipeMapper.INSTANCE.createRequestToPersistence(request_dto, tag, category);
  }

  public RecipeUpdatePersistenceDTO getPersistenceUpdateDTO(RecipeUpdateRequestDTO request_dto) {
    TagEntity tag = request_dto.tag_uuid() != null? tag_service.getEntityByUuid(request_dto.tag_uuid()) : null;
    CategoryEntity category = request_dto.category_uuid() != null? category_service.getEntityByUuid(request_dto.category_uuid()) : null;
    return RecipeMapper.INSTANCE.updateRequestToPersistence(request_dto, tag, category);
  }

  // OVERRIDE
  public RecipeReturnDTO create(RecipeCreateRequestDTO request_dto) {
    RecipeEntity recipe = super.createAndGetEntity(request_dto);

    section_service.createAll(request_dto.sections(), recipe);
    media_service.createAll(request_dto.media(), recipe);
    ingredient_service.createAll(request_dto.ingredients(), recipe);

    return RecipeMapper.INSTANCE.entityToReturn(recipe);
  }

  @Override
  public RecipeReturnDTO update(RecipeUpdateRequestDTO request_dto) {
    RecipeEntity recipe = super.updateAndGetEntity(request_dto);
    if(request_dto.sections() != null) section_service.updateAll(request_dto.sections(), recipe);
    if(request_dto.media() != null) media_service.updateAll(request_dto.media(), recipe, recipe.getName());
    if(request_dto.ingredients() != null) ingredient_service.updateAll(request_dto.ingredients(), recipe);
    return RecipeMapper.INSTANCE.entityToReturn(recipe);
  }

  @Override
  public void delete(String uuid) {
    RecipeEntity recipe = getEntityByUuid(uuid);
    media_service.delete(
      recipe.getName(),
      recipe.getMedia().size()
    );
    super.delete(uuid);
  }


}
