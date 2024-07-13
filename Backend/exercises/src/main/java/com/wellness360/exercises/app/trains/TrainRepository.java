package com.wellness360.exercises.app.trains;

import org.springframework.stereotype.Repository;

import com.wellness360.exercises.packages.crud.repositories.CrudRepository;

@Repository
public interface TrainRepository extends CrudRepository<TrainEntity> {
}
