package com.wellness360.users.app.settings;

import java.util.Objects;

import com.wellness360.users.app.settings.dtos.SettingsPersistenceDTO;
import com.wellness360.users.app.users.basic.UserBasicEntity;
import com.wellness360.users.packages.crud.entities.UniqueIdentifierEntity;
import com.wellness360.users.packages.crud.entities.interfaces.ICrudEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "settings")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SettingsEntity extends UniqueIdentifierEntity implements ICrudEntity<SettingsPersistenceDTO>{

  short theme;
  short two_factor_auth;
  short notifications;
  short email_notifications;

  UserBasicEntity user_basic;

  public void update(SettingsPersistenceDTO dto) {
    theme = Objects.requireNonNullElse(dto.getTheme(), theme);
    two_factor_auth = Objects.requireNonNullElse(dto.getTwo_factor_auth(), two_factor_auth);
    notifications = Objects.requireNonNullElse(dto.getEmail_notifications(), notifications);
    email_notifications = Objects.requireNonNullElse(dto.getNotifications(), email_notifications);
  }

}
