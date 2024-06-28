package com.wellness360.exercises.app.injuries;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.wellness360.exercises.packages.crud.repositories.CrudRepository;

@Repository
public interface InjuryRepository extends CrudRepository<InjuryEntity> {

  @Query(value = "SELECT * FROM injuries WHERE user_uuid=?1", nativeQuery = true)
  List<InjuryEntity> findAllByUserUuid(String uuid);

}
