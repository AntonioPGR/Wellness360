package com.wellness360.users.app.users.user_full.dtos;

import java.sql.Date;
import com.wellness360.users.packages.crud.dtos.CrudReturnDTO;

public record UserFullReturnDTO(
  String uuid,
  String email,
  String username,
  String full_name,
  String description,
  Date birth,
  String avatar_url,
  String backdrop_url,
  char gender,
  int height,
  String work_as,
  Integer active,
  String role
) implements CrudReturnDTO {
}
