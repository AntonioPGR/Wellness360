package com.wellness360.nutrition.app.recipe.dtos;

import com.wellness360.nutrition.app.category.CategoryEntity;
import com.wellness360.nutrition.packages.crud.dtos.CrudCreatePersistenceDTO;

public record RecipeCreatePersistenceDTO(
  String name,
  String description,
  String user_uuid,
  CategoryEntity category
) implements CrudCreatePersistenceDTO{}
