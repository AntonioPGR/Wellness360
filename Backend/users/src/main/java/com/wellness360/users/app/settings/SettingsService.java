package com.wellness360.users.app.settings;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.wellness360.users.app.settings.dtos.SettingsMapper;
import com.wellness360.users.app.settings.dtos.SettingsReturnDTO;
import com.wellness360.users.app.settings.dtos.SettingsUpdateDTO;
import com.wellness360.users.app.users.user_basic.UserBasicEntity;
import com.wellness360.users.app.users.user_basic.UserBasicService;

import jakarta.persistence.EntityNotFoundException;

@Service
public class SettingsService {

  @Autowired
  SettingsRepository repository;
  @Autowired
  UserBasicService user_service;

  public SettingsEntity createDefault(UserBasicEntity basic_entity) {
    SettingsEntity created_entity = new SettingsEntity(basic_entity);
    return save(created_entity);
  }

  public SettingsReturnDTO update(SettingsUpdateDTO dto){
    SettingsEntity entity = getSettingsByCurrentUser();
    entity.update(dto);
    save(entity);
    return SettingsMapper.INSTANCE.entityToReturn(entity);
  }

  public SettingsReturnDTO getByUser() {
    SettingsEntity entity = getSettingsByCurrentUser();
    return SettingsMapper.INSTANCE.entityToReturn(entity);
  }

  private SettingsEntity getSettingsByCurrentUser(){
    UserBasicEntity entity = (UserBasicEntity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    if(entity.getActive() == 0) throw new EntityNotFoundException("Could not find user");
    return entity.getSettings();
  }

  public SettingsEntity save(SettingsEntity entity){
    return repository.saveAndFlush(entity);
  }

}
