package com.wellness360.users.app.users.dtos;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

  UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
  
  UserUpdateAdminDTO updateToUpdateAdmin(UserUpdateDTO dto, String uuid);
  
}
