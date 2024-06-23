package com.wellness360.exercises.app.focus;

import org.springframework.stereotype.Repository;

import com.wellness360.exercises.packages.crud.repositories.CrudRepository;

@Repository
public interface FocusRepository extends CrudRepository<FocusEntity> {
}
