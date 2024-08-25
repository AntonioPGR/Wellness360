package com.wellness360.users.app.settings;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wellness360.users.app.users.user_basic.UserBasicEntity;

@Repository
public interface SettingsRepository extends JpaRepository<SettingsEntity, Integer>{

  Optional<SettingsEntity> findByUser(UserBasicEntity user);
  
}
