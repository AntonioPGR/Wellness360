package com.wellness360.exercises.settings.interfaces;

public interface ISubmuscle extends IImageEnum {
  String getGroupName();

  @Override
  default String getPackge() {
    return "muscles/" + getGroupName().toLowerCase();
  }

}