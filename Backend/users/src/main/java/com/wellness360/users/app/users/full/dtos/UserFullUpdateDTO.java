package com.wellness360.users.app.users.full.dtos;

import java.sql.Date;

import com.wellness360.users.app.users.basic.UserBasicEntity;
import com.wellness360.users.packages.crud.dtos.CrudUpdatePersistenceDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserFullUpdateDTO extends CrudUpdatePersistenceDTO {
  String uuid;
  String description;
  Date birth;
  String backdrop_url;
  char gender;
  int height;
  String full_name;
  String work_as;
  UserBasicEntity user_basic;
}
