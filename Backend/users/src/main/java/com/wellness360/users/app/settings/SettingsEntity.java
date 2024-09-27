package com.wellness360.users.app.settings;

import java.util.Objects;

import com.wellness360.users.app.settings.dtos.SettingsUpdateDTO;
import com.wellness360.users.app.users.user_basic.UserBasicEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "settings")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SettingsEntity{

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  protected Integer id;

  public short theme = 1;
  public short two_factor_auth = 1;
  public short notifications = 1;
  public short email_notifications = 1;

  // user_id
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "user_id", referencedColumnName = "id")
  public UserBasicEntity user;

  public void update(SettingsUpdateDTO dto) {
    theme = Objects.requireNonNullElse(dto.theme().shortValue(), theme);
    two_factor_auth = Objects.requireNonNullElse(dto.two_factor_auth().shortValue(), two_factor_auth);
    notifications = Objects.requireNonNullElse(dto.email_notifications().shortValue(), notifications);
    email_notifications = Objects.requireNonNullElse(dto.notifications().shortValue(), email_notifications);
  }

}
