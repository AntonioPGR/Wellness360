package com.wellness360.nutrition.app.food.dtos;

import com.wellness360.nutrition.app.category.CategoryEntity;
import com.wellness360.nutrition.packages.crud.dtos.CrudCreatePersistenceDTO;

public record FoodCreatePersistenceDTO(
  String name,
  String description,
  FoodNutrientsDTO nutrients,
  String image_url,
  CategoryEntity category
) implements CrudCreatePersistenceDTO {
}
