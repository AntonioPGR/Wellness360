package com.wellness360.nutrition.food.DTO;

import com.wellness360.nutrition.food.FoodDocument;

public class FoodReturnDTO {
  public String name;
  public String description;
  public Float carbs;
  public Float proteins;
  public Float fats;
  public Float saturated_fats;
  public Float dietary_fibre;
  public Float sodium;
  public Integer serving_amount;
  public Integer calories;
  
  public FoodReturnDTO(FoodDocument document){
    this.name = document.getName();
    this.description = document.getDescription();
    this.serving_amount = document.getServing_amount();
    this.carbs = document.getCarbs();
    this.proteins = document.getProteins();
    this.fats = document.getFats();
    this.saturated_fats = document.getSaturated_fats();
    this.dietary_fibre = document.getDietary_fibre();
    this.sodium = document.getSodium();
    this.calories = document.getCalories();
  }
}

