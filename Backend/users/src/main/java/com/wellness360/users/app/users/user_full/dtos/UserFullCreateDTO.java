package com.wellness360.users.app.users.user_full.dtos;

import java.sql.Date;

import com.wellness360.users.app.users.user_basic.UserBasicEntity;
import com.wellness360.users.packages.crud.dtos.CrudCreatePersistenceDTO;

public record UserFullCreateDTO(
  String description,
  Date birth,
  String backdrop_url,
  char gender,
  int height,
  String full_name,
  String work_as,
  UserBasicEntity user
) implements CrudCreatePersistenceDTO {
}
