package com.wellness360.nutrition.app.recipe;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wellness360.nutrition.app.recipe.dtos.RecipeCreateIdsDTO;
import com.wellness360.nutrition.app.recipe.dtos.RecipeReturnDTO;
import com.wellness360.nutrition.app.recipe.dtos.RecipeUpdateIdsDTO;
import com.wellness360.nutrition.common.CrudBases.CrudController;

@RestController
@RequestMapping("${path.recipe}")
public class RecipeController extends CrudController<
  RecipeCreateIdsDTO,
  RecipeUpdateIdsDTO,
  RecipeReturnDTO,
  RecipeService
>{

  @Autowired
  RecipeService service;

  @Override
  public RecipeReturnDTO createEntity(RecipeCreateIdsDTO create_dto) {
    return service.create(create_dto);
  }

  @Override
  public Optional<RecipeReturnDTO> updateEntity(RecipeUpdateIdsDTO update_dto) {
    return service.update(update_dto);
  }
  
}
