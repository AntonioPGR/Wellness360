package com.wellness360.users.app.settings.dtos;

import com.wellness360.users.validation.Validator;

public record SettingsUpdateDTO(
  Integer theme,
  Integer two_factor_auth,
  Integer notifications,
  Integer email_notifications
){

  public void validate(Validator validator) {
    validator.number.validateShort(theme);
    validator.number.validateShort(two_factor_auth);
    validator.number.validateShort(notifications);
    validator.number.validateShort(email_notifications);
  }
}
