package com.wellness360.users.app.users.dtos;

import java.sql.Date;

import com.wellness360.users.packages.crud.dtos.CrudReturnDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserReturnDTO extends CrudReturnDTO {
  String uuid;
  String username;
  String avatar_url;
  String email;
  String password;
  String description;
  Date birth;
  String backdrop_url;
  char gender;
  int height;
  String full_name;
  String work_as;
}
