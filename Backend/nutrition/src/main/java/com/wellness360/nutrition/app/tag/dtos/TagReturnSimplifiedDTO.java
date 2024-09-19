package com.wellness360.nutrition.app.tag.dtos;

import com.wellness360.nutrition.packages.crud.dtos.CrudReturnDTO;

public record TagReturnSimplifiedDTO(
  String uuid,
  String name,
  String description,
  String image_url
) implements CrudReturnDTO{
}