package com.wellness360.nutrition.app.food.dtos;

import lombok.Getter;

@Getter
public class FoodNutrientsDTO{
  public Float carbs;
  public Float proteins;
  public Float fats;
  public Float saturated_fats;
  public Float sodium;
  public Float dietary_fiber;
  public Short serving_amount = 100;
  public Float calories;
  private Short dto_serving_amount;

  public FoodNutrientsDTO(FoodCreateRequestDTO dto) {
    dto_serving_amount = dto.serving_amount();
    carbs = equalizeAmount(dto.carbs());
    proteins = equalizeAmount(dto.proteins());
    fats = equalizeAmount(dto.fats());
    saturated_fats = equalizeAmount(dto.saturated_fats());
    sodium = equalizeAmount(dto.sodium());
    dietary_fiber = equalizeAmount(dto.dietary_fiber());
    calories = carbs*4 + proteins*4 + fats*9;
  }

  public FoodNutrientsDTO(FoodUpdateRequestDTO dto) {
    dto_serving_amount = dto.serving_amount();
    carbs = dto.carbs() != null? equalizeAmount(dto.carbs()) : null;
    proteins = dto.proteins() != null? equalizeAmount(dto.proteins()) : null;
    fats = dto.fats() != null? equalizeAmount(dto.fats()) : null;
    saturated_fats = dto.saturated_fats() != null? equalizeAmount(dto.saturated_fats()) : null;
    sodium = dto.sodium() != null? equalizeAmount(dto.sodium()) : null;
    dietary_fiber = dto.dietary_fiber() != null? equalizeAmount(dto.dietary_fiber()) : null;
  }

  public Float equalizeAmount(float item){
    return (item / dto_serving_amount) * serving_amount;
  }

}
