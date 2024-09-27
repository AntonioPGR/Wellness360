package com.wellness360.nutrition.app.recipe.section;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wellness360.nutrition.app.recipe.RecipeEntity;
import com.wellness360.nutrition.app.recipe.RecipeService;
import com.wellness360.nutrition.app.recipe.section.dtos.SectionCreatePersistenceDTO;
import com.wellness360.nutrition.app.recipe.section.dtos.SectionCreateRequestDTO;
import com.wellness360.nutrition.app.recipe.section.dtos.SectionMapper;
import com.wellness360.nutrition.app.recipe.section.dtos.SectionReturnDTO;
import com.wellness360.nutrition.app.recipe.section.dtos.SectionUpdatePersistenceDTO;
import com.wellness360.nutrition.app.recipe.section.dtos.SectionUpdateRequestDTO;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class SectionService{

  @Autowired
  SectionRepository repository;

  @Autowired
  RecipeService recipe_service;
  
  public void createAll(List<SectionCreateRequestDTO> dto_list, RecipeEntity recipe){
    dto_list.stream().forEach((dto) -> create(dto, recipe));
  }
  public SectionReturnDTO create(SectionCreateRequestDTO dto, RecipeEntity recipe){
    String included_recipe_uuid = dto.getIncluded_recipe_uuid();
    RecipeEntity included_recipe = null;
    if(included_recipe_uuid != null) included_recipe = recipe_service.getEntityByUuid(included_recipe_uuid);
    SectionCreatePersistenceDTO create_dto = SectionMapper.INSTANCE.createRequestToPersistence(dto, recipe, included_recipe);
    SectionEntity entity = SectionMapper.INSTANCE.createPersistenceToEntity(create_dto);
    entity = repository.save(entity);
    return SectionMapper.INSTANCE.entityToReturn(entity);
  }

  public void updateAll(List<SectionUpdateRequestDTO> dto_list, RecipeEntity recipe) {
    dto_list.stream().forEach((dto) -> update(dto, recipe));
  }
  public SectionReturnDTO update(SectionUpdateRequestDTO dto, RecipeEntity recipe){
    SectionEntity entity = repository.findByUuid(dto.uuid())
      .orElseThrow(() -> new EntityNotFoundException("Could not found section with passed uuid"));
    RecipeEntity included_recipe = recipe_service.getEntityByUuid(dto.included_recipe_uuid());
    SectionUpdatePersistenceDTO update_dto = SectionMapper.INSTANCE.updateRequestToPersistence(dto, recipe, included_recipe);
    entity.update(update_dto);
    return SectionMapper.INSTANCE.entityToReturn(entity);
  }
}
