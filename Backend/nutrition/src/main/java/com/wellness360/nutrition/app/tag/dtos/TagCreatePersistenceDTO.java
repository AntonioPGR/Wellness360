package com.wellness360.nutrition.app.tag.dtos;

import com.wellness360.nutrition.app.category.CategoryEntity;
import com.wellness360.nutrition.packages.crud.dtos.CrudCreatePersistenceDTO;

public record TagCreatePersistenceDTO(
  String name,
  String description,
  String image_url,
  CategoryEntity category
) implements CrudCreatePersistenceDTO{
}

