package com.wellness360.users.app.users.user_basic.dtos;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.wellness360.users.app.users.dtos.UserCreateDTO;
import com.wellness360.users.app.users.dtos.UserUpdateAdminDTO;
import com.wellness360.users.app.users.user_basic.UserBasicEntity;

@Mapper
public interface UserBasicMapper {

  UserBasicMapper INSTANCE = Mappers.getMapper(UserBasicMapper.class);
  
  UserBasicCreateDTO CreateToUserBasicCreate(UserCreateDTO dto, String avatar_url);
  UserBasicReturnDTO BasicEntityToBasicReturn(UserBasicEntity entity);
  UserBasicUpdateDTO UpdateToBasicUpdate(UserUpdateAdminDTO dto, String avatar_url);
  
  @Mapping(ignore=true, target="active") 
  @Mapping(ignore=true, target="full_info") 
  @Mapping(ignore=true, target="role") 
  @Mapping(ignore=true, target="settings") 
  @Mapping(ignore=true, target="authorities")
  UserBasicEntity basicCreateToEntity(UserBasicCreateDTO dto);

}
