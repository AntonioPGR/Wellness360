package com.wellness360.nutrition.app.category.dtos;

import com.wellness360.nutrition.packages.crud.dtos.CrudReturnDTO;

public record CategoryReturnDTO(
  String uuid,
  String name,
  String description,
  String image_url
) implements CrudReturnDTO {
}
