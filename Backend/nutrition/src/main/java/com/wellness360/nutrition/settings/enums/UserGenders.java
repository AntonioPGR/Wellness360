package com.wellness360.nutrition.settings.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum UserGenders {
  MALE("M"),
  FEMALE("F"),
  OTHER("N");

  String gender;
}
