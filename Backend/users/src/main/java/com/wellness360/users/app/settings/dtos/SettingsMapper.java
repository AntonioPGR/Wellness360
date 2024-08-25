package com.wellness360.users.app.settings.dtos;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.wellness360.users.app.settings.SettingsEntity;

@Mapper
public interface SettingsMapper {

  SettingsMapper INSTANCE = Mappers.getMapper(SettingsMapper.class);
  
  SettingsReturnDTO entityToReturn(SettingsEntity entity);

}
