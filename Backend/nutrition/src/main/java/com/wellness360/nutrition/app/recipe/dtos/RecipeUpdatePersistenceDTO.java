package com.wellness360.nutrition.app.recipe.dtos;

import com.wellness360.nutrition.app.category.CategoryEntity;
import com.wellness360.nutrition.packages.crud.dtos.CrudUpdatePersistenceDTO;

public record RecipeUpdatePersistenceDTO(
  String uuid,
  String name,
  String description,
  String user_uuid,
  CategoryEntity category
) implements CrudUpdatePersistenceDTO {
}
