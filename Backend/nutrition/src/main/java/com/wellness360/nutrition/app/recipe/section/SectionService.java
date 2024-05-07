package com.wellness360.nutrition.app.recipe.section;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wellness360.nutrition.app.recipe.RecipeEntity;
import com.wellness360.nutrition.app.recipe.section.dtos.SectionCreateEntitiesDTO;
import com.wellness360.nutrition.app.recipe.section.dtos.SectionCreateIdsDTO;
import com.wellness360.nutrition.app.recipe.section.dtos.SectionReturnDTO;
import com.wellness360.nutrition.app.recipe.section.dtos.SectionUpdateEntitiesDTO;
import com.wellness360.nutrition.app.recipe.section.dtos.SectionUpdateIdsDTO;
import com.wellness360.nutrition.common.CrudBases.CrudService;
import com.wellness360.nutrition.tools.EntityRetrieverByUUID;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class SectionService extends CrudService<
  SectionRepository,
  SectionCreateEntitiesDTO,
  SectionUpdateEntitiesDTO,
  SectionReturnDTO,
  SectionEntity
> {

  @Autowired
  SectionRepository repository;
  @Autowired
  EntityRetrieverByUUID uuid_getter;
  
  public void createAll(List<SectionCreateIdsDTO> dto_list, RecipeEntity recipe){
    dto_list.stream().forEach((dto) -> create(dto, recipe));
  }

  public SectionReturnDTO create(SectionCreateIdsDTO dto, RecipeEntity recipe){
    SectionCreateEntitiesDTO create_dto = new SectionCreateEntitiesDTO(dto, recipe);
    return super.create(create_dto);
  }

  public void updateAll(List<SectionUpdateIdsDTO> dto_list, RecipeEntity recipe) {
    dto_list.stream().forEach((dto) -> update(dto, recipe));
  }

  public Optional<SectionReturnDTO> update(SectionUpdateIdsDTO dto, RecipeEntity recipe){
    RecipeEntity included_recipe = uuid_getter.getRecipeByUuid(dto.getIncluded_recipe_uuid());
    SectionUpdateEntitiesDTO update_dto = new SectionUpdateEntitiesDTO(dto, recipe, included_recipe);
    return super.update(update_dto);
  }

  // INHERIT
  @Override
  public SectionReturnDTO entityToReturnDTO(SectionEntity entity) {
    return new SectionReturnDTO(entity);
  }

  @Override
  public SectionEntity createDTOtoEntity(SectionCreateEntitiesDTO dto) {
    return new SectionEntity(dto);
  }

  

}
