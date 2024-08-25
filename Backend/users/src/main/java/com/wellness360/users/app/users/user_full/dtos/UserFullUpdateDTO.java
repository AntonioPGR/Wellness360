package com.wellness360.users.app.users.user_full.dtos;

import java.sql.Date;

import com.wellness360.users.app.users.dtos.UserUpdateAdminDTO;
import com.wellness360.users.packages.crud.dtos.CrudUpdatePersistenceDTO;

public record UserFullUpdateDTO(
  String uuid,
  String description,
  Date birth,
  String backdrop_url,
  char gender,
  int height,
  String full_name,
  String work_as
) implements CrudUpdatePersistenceDTO {
  
  public UserFullUpdateDTO(UserUpdateAdminDTO dto, String backdrop_url) {
    this(
      dto.uuid(),
      dto.description(),
      dto.birth(),
      backdrop_url,
      dto.gender(),
      dto.height(),
      dto.full_name(),
      dto.work_as()
    );
  }

}
