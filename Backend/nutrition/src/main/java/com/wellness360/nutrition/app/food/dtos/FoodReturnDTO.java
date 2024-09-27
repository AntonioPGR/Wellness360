package com.wellness360.nutrition.app.food.dtos;

import com.wellness360.nutrition.app.category.dtos.CategoryReturnDTO;
import com.wellness360.nutrition.packages.crud.dtos.CrudReturnDTO;

public record FoodReturnDTO(
  String uuid,
  String name,
  String description,
  Float calories,
  Float carbs,
  Float proteins,
  Float fats,
  Float saturated_fats,
  Float sodium,
  Float dietary_fiber,
  Short serving_amount,
  String image_url,
  CategoryReturnDTO category
) implements CrudReturnDTO{
}
