package com.wellness360.nutrition.app.tag.dtos;

import com.wellness360.nutrition.app.category.CategoryEntity;
import com.wellness360.nutrition.packages.crud.dtos.CrudUpdatePersistenceDTO;

public record TagUpdatePersistenceDTO(
  String uuid,
  String name,
  String description,
  String image_url,
  CategoryEntity category
) implements CrudUpdatePersistenceDTO{
}