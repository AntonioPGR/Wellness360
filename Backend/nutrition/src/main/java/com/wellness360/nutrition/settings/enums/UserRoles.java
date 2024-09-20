package com.wellness360.nutrition.settings.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum UserRoles {
  USER("USER"),
  ADMIN("ADMIN");

  private String role;

}
