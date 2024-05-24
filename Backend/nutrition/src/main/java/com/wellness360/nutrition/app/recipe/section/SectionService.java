package com.wellness360.nutrition.app.recipe.section;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wellness360.nutrition.app.recipe.RecipeEntity;
import com.wellness360.nutrition.app.recipe.section.dtos.SectionCreatePersistenceDTO;
import com.wellness360.nutrition.app.recipe.section.dtos.SectionCreateRequestDTO;
import com.wellness360.nutrition.app.recipe.section.dtos.SectionReturnDTO;
import com.wellness360.nutrition.app.recipe.section.dtos.SectionUpdatePersistenceDTO;
import com.wellness360.nutrition.app.recipe.section.dtos.SectionUpdateRequestDTO;
import com.wellness360.nutrition.common.tools.EntityRetrieverByUUID;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class SectionService{

  @Autowired
  SectionRepository repository;
  @Autowired
  EntityRetrieverByUUID uuid_getter;
  
  public void createAll(List<SectionCreateRequestDTO> dto_list, RecipeEntity recipe){
    dto_list.stream().forEach((dto) -> create(dto, recipe));
  }
  public SectionReturnDTO create(SectionCreateRequestDTO dto, RecipeEntity recipe){
    String included_recipe_uuid = dto.getIncluded_recipe_uuid();
    RecipeEntity included_recipe = null;
    if(included_recipe_uuid != null){
      Optional<RecipeEntity> included_recipe_opt = uuid_getter.getRecipeByUuid(included_recipe_uuid);
      if(included_recipe_opt.isPresent()) included_recipe = included_recipe_opt.get();
    }

    SectionCreatePersistenceDTO create_dto = new SectionCreatePersistenceDTO(dto, recipe, included_recipe);
    SectionEntity entity = new SectionEntity(create_dto);
    entity = repository.save(entity);
    return new SectionReturnDTO(entity);
  }

  public void updateAll(List<SectionUpdateRequestDTO> dto_list, RecipeEntity recipe) {
    dto_list.stream().forEach((dto) -> update(dto, recipe));
  }
  public SectionReturnDTO update(SectionUpdateRequestDTO dto, RecipeEntity recipe){
    RecipeEntity included_recipe = uuid_getter.getRecipeByUuid(dto.getIncluded_recipe_uuid()).get();
    SectionUpdatePersistenceDTO update_dto = new SectionUpdatePersistenceDTO(dto, recipe, included_recipe);
    Optional<SectionEntity> opt_entity = repository.findByUuid(dto.getUuid());
    if(opt_entity.isEmpty()) return null;
    SectionEntity entity = opt_entity.get();
    entity.update(update_dto);
    return new SectionReturnDTO(entity);
  }
}
