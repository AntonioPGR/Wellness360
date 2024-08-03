package com.wellness360.users.app.settings.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SettingsReturnDTO {
  
  int theme;
  int two_factor_auth;
  int notifications;
  int email_notifications;

}
