package com.wellness360.users.app.users.user_full.dtos;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.wellness360.users.app.users.dtos.UserCreateDTO;
import com.wellness360.users.app.users.user_basic.UserBasicEntity;
import com.wellness360.users.app.users.user_full.UserFullEntity;

@Mapper
public interface UserFullMapper {
  
  UserFullMapper INSTANCE = Mappers.getMapper(UserFullMapper.class);

  UserFullCreateDTO createToFullCreate(UserCreateDTO dto, String backdrop_url, UserBasicEntity user);

  @Mapping(source = "entity.user.uuid", target = "uuid")
  @Mapping(source = "entity.user.email", target = "email")
  @Mapping(source = "entity.user.username", target = "username")
  @Mapping(source = "entity.user.avatar_url", target = "avatar_url")
  @Mapping(source = "entity.user.active", target = "active")
  @Mapping(source = "entity.user.role", target = "role")
  UserFullReturnDTO fullEntityToFullReturn(UserFullEntity entity);

  @Mapping(source = "full_info.full_name", target = "full_name")
  @Mapping(source = "full_info.description", target = "description")
  @Mapping(source = "full_info.birth", target = "birth")
  @Mapping(source = "full_info.backdrop_url", target = "backdrop_url")
  @Mapping(source = "full_info.gender", target = "gender")
  @Mapping(source = "full_info.height", target = "height")
  @Mapping(source = "full_info.work_as", target = "work_as")
  UserFullReturnDTO BasicEntityToReturnFull(UserBasicEntity user);

}
