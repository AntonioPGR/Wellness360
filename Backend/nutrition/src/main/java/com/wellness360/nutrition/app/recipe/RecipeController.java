package com.wellness360.nutrition.app.recipe;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wellness360.nutrition.app.recipe.dtos.RecipeCreateRequestDTO;
import com.wellness360.nutrition.app.recipe.dtos.RecipeReturnDTO;
import com.wellness360.nutrition.app.recipe.dtos.RecipeUpdateRequestDTO;
import com.wellness360.nutrition.packages.crud.controllers.CrudStorageController;

@RestController
@RequestMapping("${path.recipe}")
public class RecipeController extends CrudStorageController<
  RecipeCreateRequestDTO,
  RecipeUpdateRequestDTO,
  RecipeReturnDTO,
  RecipeService
>{}
