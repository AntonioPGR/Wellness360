package com.wellness360.nutrition.app.category.dtos;

import com.wellness360.nutrition.packages.crud.dtos.CrudCreatePersistenceDTO;

public record CategoryCreatePersistenceDTO(
  String name,
  String description,
  String image_url
) implements CrudCreatePersistenceDTO {
}
