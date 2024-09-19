package com.wellness360.users.app.users.basic;

import java.util.Objects;

import com.wellness360.users.app.settings.SettingsEntity;
import com.wellness360.users.app.users.basic.dtos.UserBasicUpdateDTO;
import com.wellness360.users.app.users.full.UserFullEntity;
import com.wellness360.users.packages.crud.entities.UniqueIdentifierEntity;
import com.wellness360.users.packages.crud.entities.interfaces.ICrudEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity
@Table(name = "users_basic")
@Getter
public class UserBasicEntity extends UniqueIdentifierEntity implements ICrudEntity<UserBasicUpdateDTO>{
  
  String username;
  String avatar_url;
  String email;
  String password;

  UserFullEntity full_info;
  SettingsEntity settings;

  public void update(UserBasicUpdateDTO dto) {
    username = Objects.requireNonNullElse(dto.getUsername(), username);
    avatar_url = Objects.requireNonNullElse(dto.getAvatar_url(), avatar_url);
    email = Objects.requireNonNullElse(dto.getEmail(), email);
    password = Objects.requireNonNullElse(dto.getPassword(), password);
  }



}
