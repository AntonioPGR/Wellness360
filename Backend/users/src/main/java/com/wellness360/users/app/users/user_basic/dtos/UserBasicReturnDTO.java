package com.wellness360.users.app.users.user_basic.dtos;

import com.wellness360.users.packages.crud.dtos.CrudReturnDTO;

public record UserBasicReturnDTO(
  String uuid,
  String email,
  String username,
  String avatar_url,
  Integer active,
  String role
) implements CrudReturnDTO{
}
