package com.wellness360.exercises.enums.interfaces;

public interface IImageEnum {
  String name();

  default String getImageUrl(){
    return this.name().toLowerCase() + ".png";
  }
  
}
