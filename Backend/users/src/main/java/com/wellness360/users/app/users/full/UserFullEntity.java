package com.wellness360.users.app.users.full;

import java.sql.Date;
import java.util.Objects;

import com.wellness360.users.app.users.basic.UserBasicEntity;
import com.wellness360.users.app.users.full.dtos.UserFullCreateDTO;
import com.wellness360.users.app.users.full.dtos.UserFullUpdateDTO;
import com.wellness360.users.packages.crud.entities.UniqueIdentifierEntity;
import com.wellness360.users.packages.crud.entities.interfaces.ICrudEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity
@Table(name = "users_full")
@Getter
public class UserFullEntity extends UniqueIdentifierEntity implements ICrudEntity<UserFullUpdateDTO> {
  
  String description;
  Date birth;
  String backdrop_url;
  char gender;
  int height;
  String full_name;
  String work_as;
  Date created_at;

  UserBasicEntity user_basic;

  public void update(UserFullUpdateDTO dto) {
    description = Objects.requireNonNullElse(dto.getDescription(), description);
    birth = Objects.requireNonNullElse(dto.getBirth(), birth);
    backdrop_url = Objects.requireNonNullElse(dto.getBackdrop_url(), backdrop_url);
    gender = Objects.requireNonNullElse(dto.getGender(), gender);
    height = Objects.requireNonNullElse(dto.getHeight(), height);
    full_name = Objects.requireNonNullElse(dto.getFull_name(), full_name);
    work_as = Objects.requireNonNullElse(dto.getWork_as(), work_as);
  }

  public void update(UserFullCreateDTO dto) {
    description = dto.getDescription();
    birth = dto.getBirth();
    backdrop_url = dto.getBackdrop_url();
    gender = dto.getGender();
    height = dto.getHeight();
    full_name = dto.getFull_name();
    work_as = dto.getWork_as();
  }

}
