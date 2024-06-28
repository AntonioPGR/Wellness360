package com.wellness360.exercises.app.focus;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.wellness360.exercises.packages.crud.repositories.CrudRepository;

@Repository
public interface FocusRepository extends CrudRepository<FocusEntity> {

  @Query(value = "SELECT * FROM body_focus WHERE user_uuid=?1", nativeQuery = true)
  List<FocusEntity> findAllByUserUuid(String uuid);
}
