package com.wellness360.users.app.users.basic.dtos;

import com.wellness360.users.packages.crud.dtos.CrudReturnDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserBasicReturnDTO extends CrudReturnDTO {
  String uuid;
  String username;
  String avatar_url;
  String email;
}
