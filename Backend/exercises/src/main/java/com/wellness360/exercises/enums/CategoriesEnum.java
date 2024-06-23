package com.wellness360.exercises.enums;

import com.wellness360.exercises.enums.interfaces.IImageEnum;

public enum CategoriesEnum implements IImageEnum {
  CARDIO,
  STRENGHT,
  FLEXIBILITY;

  public String getPackge() {
    return "categories";
  }
}
