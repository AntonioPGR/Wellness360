package com.wellness360.users.app.users;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.wellness360.users.app.settings.SettingsEntity;
import com.wellness360.users.app.settings.SettingsService;
import com.wellness360.users.app.users.dtos.UserCreateDTO;
import com.wellness360.users.app.users.dtos.UserLoginDTO;
import com.wellness360.users.app.users.dtos.UserMapper;
import com.wellness360.users.app.users.dtos.UserReturnTokenDTO;
import com.wellness360.users.app.users.dtos.UserUpdateAdminDTO;
import com.wellness360.users.app.users.dtos.UserUpdateDTO;
import com.wellness360.users.app.users.user_basic.UserBasicEntity;
import com.wellness360.users.app.users.user_basic.UserBasicRepository;
import com.wellness360.users.app.users.user_basic.UserBasicService;
import com.wellness360.users.app.users.user_basic.dtos.UserBasicMapper;
import com.wellness360.users.app.users.user_basic.dtos.UserBasicReturnDTO;
import com.wellness360.users.app.users.user_full.UserFullEntity;
import com.wellness360.users.app.users.user_full.UserFullService;
import com.wellness360.users.app.users.user_full.dtos.UserFullMapper;
import com.wellness360.users.app.users.user_full.dtos.UserFullReturnDTO;
import com.wellness360.users.packages.crud.service.interfaces.ICrudBaseService;
import com.wellness360.users.packages.crud.validations.UnauthorizedOperation;
import com.wellness360.users.security.JwtTokenService;
import com.wellness360.users.validation.Validator;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;


@Service
@Transactional
public class UserService implements ICrudBaseService<
  UserCreateDTO,
  UserUpdateAdminDTO,
  UserFullReturnDTO
> {

  @Autowired
  UserBasicService basic_service;
  @Autowired
  UserFullService full_service;
  @Autowired
  SettingsService settings_service;

  @Autowired
  UserBasicRepository repository;
  @Autowired
  Validator validator;
  @Autowired
  JwtTokenService token_service;

  // LISTS
  public UserBasicReturnDTO getCurrentBasic() {
    UserBasicEntity entity = getUserFromAuth();
    checkUserIsActive(entity);
    return UserBasicMapper.INSTANCE.BasicEntityToBasicReturn(entity);
  }

  public UserFullReturnDTO getCurrentFull(){
    UserBasicEntity entity = getUserFromAuth();
    checkUserIsActive(entity);
    return UserFullMapper.INSTANCE.BasicEntityToReturnFull(entity);
  }

  public UserFullReturnDTO getByUuid(String uuid) {
    UserBasicEntity user = basic_service.getEntityByUuid(uuid);
    return UserFullMapper.INSTANCE.BasicEntityToReturnFull(user);
  }

  public Page<UserBasicReturnDTO> getAllBasic(Pageable pageable) {
    Page<UserBasicEntity> users = basic_service.getAllAsEntity(pageable);
    return users.map((user) -> UserBasicMapper.INSTANCE.BasicEntityToBasicReturn(user));
  }

  public Page<UserFullReturnDTO> getAll(Pageable pageable) {
    Page<UserBasicEntity> users = basic_service.getAllAsEntity(pageable);
    return users.map((user) -> UserFullMapper.INSTANCE.BasicEntityToReturnFull(user));
  }

  // CREATE
  public UserFullReturnDTO create(UserCreateDTO create_dto) {
    create_dto.validate(validator);
    UserBasicEntity basic_entity = basic_service.createAndGetEntity(create_dto);
    UserFullEntity full= full_service.create(create_dto, basic_entity);
    SettingsEntity settings = settings_service.createDefault(basic_entity);
    basic_entity.setSettings(settings);
    basic_entity.setFull_info(full);
    repository.saveAndFlush(basic_entity);
    return UserFullMapper.INSTANCE.BasicEntityToReturnFull(basic_entity);
  }

  // UPDATE
  public UserFullReturnDTO updateCurrent(UserUpdateDTO dto) {
    dto.validate(validator);
    UserBasicEntity base_entity = getUserFromAuth();
    checkUserIsActive(base_entity);
    UserUpdateAdminDTO update_dto = UserMapper.INSTANCE.updateToUpdateAdmin(dto, base_entity.getUuid());
    basic_service.update(update_dto);
    full_service.update(update_dto, base_entity);
    UserBasicEntity return_entity = basic_service.getEntityByUuid(base_entity.getUuid());
    return UserFullMapper.INSTANCE.BasicEntityToReturnFull(return_entity);
  }

  public UserFullReturnDTO update(UserUpdateAdminDTO update_dto) {
    update_dto.validate(validator);
    UserBasicEntity base_entity = basic_service.updateAndGetEntity(update_dto);
    checkUserIsActive(base_entity);
    full_service.update(update_dto, base_entity);
    return UserFullMapper.INSTANCE.BasicEntityToReturnFull(base_entity);
  }

  // DELETE
  public void delete(String uuid) {
    checkUserIsActive(getUserFromAuth());
    basic_service.delete(uuid);
  }

  public void deactivate() {
    UserBasicEntity entity = getUserFromAuth();
    checkUserIsActive(entity);
    basic_service.deactivate(entity);
  }

  // AUTH
  public UserReturnTokenDTO authenticate(UserLoginDTO dto) {
    UserBasicEntity entity = getUserByEmail(dto.email());
    checkUserIsActive(entity);
    if(userPasswordMatches(dto.password(), entity.getPassword())){
      String token = token_service.generateToken(entity.getUsername());
      return new UserReturnTokenDTO(token);
    }
    throw new UnauthorizedOperation("The password doesn't match the one saved");
  }

  // UTILS
  private UserBasicEntity getUserFromAuth(){
    return (UserBasicEntity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
  }

  private void checkUserIsActive(UserBasicEntity entity){
    if(entity.getActive() == 0) throw new EntityNotFoundException("This users was deactivated");
  }

  private UserBasicEntity getUserByEmail(String email){
    return repository.findByEmail(email)
      .orElseThrow(() -> new EntityNotFoundException("Could not find any entities with passed email"));
  }

  private boolean userPasswordMatches(String check_password, String password){
    return new BCryptPasswordEncoder().matches(check_password, password);
  }

  
}
