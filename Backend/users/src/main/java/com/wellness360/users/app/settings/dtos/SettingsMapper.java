package com.wellness360.users.app.settings.dtos;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.wellness360.users.app.settings.SettingsEntity;
import com.wellness360.users.app.users.user_basic.UserBasicEntity;

@Mapper
public interface SettingsMapper {

  SettingsMapper INSTANCE = Mappers.getMapper(SettingsMapper.class);
  
  @Mapping(source="entity.theme", target="theme")
  @Mapping(source="entity.two_factor_auth", target="two_factor_auth")
  @Mapping(source="entity.notifications", target="notifications")
  @Mapping(source="entity.email_notifications", target="email_notifications")
  SettingsReturnDTO entityToReturn(SettingsEntity entity);

  @Mapping(source = "user", target = "user")
  @Mapping(ignore=true, target="email_notifications")
  @Mapping(ignore=true, target="notifications")
  @Mapping(ignore=true, target="theme")
  @Mapping(ignore=true, target="two_factor_auth")
  SettingsEntity userToEntity(UserBasicEntity user);

}
