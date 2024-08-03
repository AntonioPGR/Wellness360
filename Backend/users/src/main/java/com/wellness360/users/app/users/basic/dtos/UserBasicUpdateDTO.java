package com.wellness360.users.app.users.basic.dtos;

import com.wellness360.users.packages.crud.dtos.CrudUpdatePersistenceDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserBasicUpdateDTO extends CrudUpdatePersistenceDTO {
  String uuid;
  String username;
  String avatar_url;
  String email;
  String password;
}
