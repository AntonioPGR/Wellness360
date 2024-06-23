package com.wellness360.exercises.enums.interfaces;

public interface IImageEnum {
  String name();
  String getPackge();
  default String getImageUrl(){
    return getPackge() + "/" + this.name().toLowerCase() + ".png";
  }
}
