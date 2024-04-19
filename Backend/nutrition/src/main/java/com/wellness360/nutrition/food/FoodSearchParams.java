package com.wellness360.nutrition.food;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FoodSearchParams {
  private String name;
  private String max_calories;
  private String min_calories;
  private String min_proteins;
  private String max_proteins;
  private String min_carbs;
  private String max_carbs;
  private String min_fats;
  private String max_fats;
  private String min_sodium;
  private String max_sodium;
  private String min_fibre;
  private String max_fibre;
  private String min_saturated;
  private String max_saturated;
}
