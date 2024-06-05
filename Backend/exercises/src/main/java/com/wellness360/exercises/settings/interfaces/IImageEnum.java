package com.wellness360.exercises.settings.interfaces;

public interface IImageEnum {
  String name();
  String getPackge();
  default String getImageUrl(){
    return getPackge() + "/" + this.name().toLowerCase() + ".png";
  }
}
