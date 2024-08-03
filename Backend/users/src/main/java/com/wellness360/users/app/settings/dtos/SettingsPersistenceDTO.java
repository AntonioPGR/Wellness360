package com.wellness360.users.app.settings.dtos;

import com.wellness360.users.app.users.basic.UserBasicEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SettingsPersistenceDTO {
  
  short theme;
  short two_factor_auth;
  short notifications;
  short email_notifications;
  UserBasicEntity user;

}
