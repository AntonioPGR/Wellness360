package com.wellness360.users.app.users.user_basic.dtos;

import com.wellness360.users.packages.crud.dtos.CrudCreatePersistenceDTO;

public record UserBasicCreateDTO(
  String username,
  String avatar_url,
  String email,
  String password
) implements CrudCreatePersistenceDTO {
}
