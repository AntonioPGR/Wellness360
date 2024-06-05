package com.wellness360.exercises.settings;

import com.wellness360.exercises.settings.interfaces.IImageEnum;

public enum CategoriesEnum implements IImageEnum {
  CARDIO,
  STRENGHT,
  FLEXIBILITY;

  public String getPackge() {
    return "categories";
  }
}
