package com.wellness360.users.app.users.basic.dtos;

import com.wellness360.users.packages.crud.dtos.CrudCreatePersistenceDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserBasicCreateDTO extends CrudCreatePersistenceDTO {
  String username;
  String avatar_url;
  String email;
  String password;
}
