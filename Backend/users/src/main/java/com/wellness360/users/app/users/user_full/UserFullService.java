package com.wellness360.users.app.users.user_full;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wellness360.users.app.users.dtos.UserUpdateAdminDTO;
import com.wellness360.users.app.users.dtos.UserCreateDTO;
import com.wellness360.users.app.users.user_basic.UserBasicEntity;
import com.wellness360.users.app.users.user_full.dtos.UserFullCreateDTO;
import com.wellness360.users.app.users.user_full.dtos.UserFullMapper;
import com.wellness360.users.app.users.user_full.dtos.UserFullUpdateDTO;
import com.wellness360.users.packages.storage.StorageService;
import com.wellness360.users.settings.storage.StorageFolders;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserFullService{

  @Autowired
  StorageService storage_service;
  @Autowired
  UserFullRepository repository;

  public UserFullEntity create(UserCreateDTO dto, UserBasicEntity basic_entity) {
    String backdrop_url = storage_service.store(dto.backdrop(), StorageFolders.backdrop.name(), dto.username());
    UserFullCreateDTO create_dto = UserFullMapper.INSTANCE.createToFullCreate(dto, backdrop_url, basic_entity);
    UserFullEntity entity = new UserFullEntity(create_dto);
    return repository.saveAndFlush(entity);
  }

  public void update(UserUpdateAdminDTO dto, UserBasicEntity base_entity) {
    UserFullEntity entity = repository.findByUser(base_entity);

    String backdrop_url = null;
    if(dto.backdrop() != null) {
      storage_service.update(dto.backdrop(), entity.getBackdrop_url());
    }

    UserFullUpdateDTO update_dto = new UserFullUpdateDTO(dto, backdrop_url);
    entity.update(update_dto);
    repository.saveAndFlush(entity);
  }


}
