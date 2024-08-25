package com.wellness360.users.settings.enums;

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
