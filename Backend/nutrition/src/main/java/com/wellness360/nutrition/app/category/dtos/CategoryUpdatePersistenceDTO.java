package com.wellness360.nutrition.app.category.dtos;

import com.wellness360.nutrition.packages.crud.dtos.CrudUpdatePersistenceDTO;

public record CategoryUpdatePersistenceDTO(
  String uuid,
  String name,
  String description,
  String image_url
) implements CrudUpdatePersistenceDTO {
}
