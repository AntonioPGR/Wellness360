package com.wellness360.nutrition.app.tag.dtos;

import com.wellness360.nutrition.app.category.dtos.CategoryReturnDTO;
import com.wellness360.nutrition.packages.crud.dtos.CrudReturnDTO;

public record TagReturnCompleteDTO(
  String uuid,
  String name,
  String description,
  String image_url,
  CategoryReturnDTO category
) implements CrudReturnDTO{
}