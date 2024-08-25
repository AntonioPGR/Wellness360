package com.wellness360.users.app.users.user_basic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wellness360.users.app.settings.SettingsEntity;
import com.wellness360.users.app.users.dtos.UserUpdateAdminDTO;
import com.wellness360.users.app.users.dtos.UserCreateDTO;
import com.wellness360.users.app.users.user_basic.dtos.UserBasicCreateDTO;
import com.wellness360.users.app.users.user_basic.dtos.UserBasicMapper;
import com.wellness360.users.app.users.user_basic.dtos.UserBasicReturnDTO;
import com.wellness360.users.app.users.user_basic.dtos.UserBasicUpdateDTO;
import com.wellness360.users.app.users.user_full.UserFullEntity;
import com.wellness360.users.packages.crud.service.CrudDtoTransformService;
import com.wellness360.users.packages.storage.StorageService;
import com.wellness360.users.settings.storage.StorageFolders;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserBasicService extends CrudDtoTransformService<
  UserBasicRepository,
  UserCreateDTO,
  UserBasicCreateDTO,
  UserUpdateAdminDTO,
  UserBasicUpdateDTO,
  UserBasicReturnDTO,
  UserBasicEntity
>{

  @Autowired
  StorageService storage_service;

  public UserBasicEntity getEntityByPersistenceDTO(UserBasicCreateDTO dto) {
    return new UserBasicEntity(dto);
  }

  public UserBasicCreateDTO getPersistenceCreateDTO(UserCreateDTO dto) {
    String avatar_url = storage_service.store(dto.avatar(), StorageFolders.profile.name(), dto.username());
    return UserBasicMapper.INSTANCE.CreateToUserBasicCreate(dto, avatar_url);
  }

  public UserBasicUpdateDTO getPersistenceUpdateDTO(UserUpdateAdminDTO dto) {
    String avatar_url = null;
    if(dto.avatar() != null){
      UserBasicEntity entity = getEntityByUuid(dto.uuid());
      avatar_url = storage_service.update(dto.avatar(), entity.getAvatar_url());
    }
    return UserBasicMapper.INSTANCE.UpdateToBasicUpdate(dto, avatar_url);
  }

  public UserBasicReturnDTO buildReturnDTO(UserBasicEntity entity) {
    return UserBasicMapper.INSTANCE.BasicEntityToBasicReturn(entity);
  }

  // OVERRIDE
  public UserBasicEntity createAndGetEntity(UserCreateDTO request_dto, UserFullEntity full, SettingsEntity settings) {
    return super.createAndGetEntity(request_dto);
  }

  public void delete(String uuid) {
    repository.findByUuid(uuid);
    repository.deleteByUuid(uuid);
  }

  public void deactivate(UserBasicEntity entity) {
    entity.deactivate();
    save(entity);
  }
  

}
