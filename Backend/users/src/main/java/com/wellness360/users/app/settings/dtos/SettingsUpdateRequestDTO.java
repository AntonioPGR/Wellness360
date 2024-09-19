package com.wellness360.users.app.settings.dtos;

import com.wellness360.users.packages.validation.ValidateService;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SettingsUpdateRequestDTO {

  int theme;
  int two_factor_auth;
  int notifications;
  int email_notifications;
  String user_uuid;

  public void validate(ValidateService validator) {
    throw new UnsupportedOperationException("Unimplemented method 'validate'");
  }
}
