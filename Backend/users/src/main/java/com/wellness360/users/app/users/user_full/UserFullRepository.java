package com.wellness360.users.app.users.user_full;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wellness360.users.app.users.user_basic.UserBasicEntity;


@Repository
public interface UserFullRepository extends JpaRepository<UserFullEntity, Integer>{

  UserFullEntity findByUser(UserBasicEntity base_entity);
  
}
