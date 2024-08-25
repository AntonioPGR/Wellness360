package com.wellness360.users.app.users.user_basic;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.wellness360.users.packages.crud.repositories.CrudRepository;
import java.util.Optional;


@Repository
public interface UserBasicRepository extends CrudRepository<UserBasicEntity> {
  
  @Override
  @Query(value = "SELECT * FROM users_basic WHERE uuid = ?1 AND active = 1", nativeQuery = true)
  Optional<UserBasicEntity> findByUuid(String uuid);

  Optional<UserBasicEntity> findByEmail(String email);

  Optional<UserBasicEntity> findByUsername(String username);

}
