package com.wellness360.nutrition.app.logs;

import org.springframework.stereotype.Repository;

import com.wellness360.nutrition.packages.crud.repositories.CrudRepository;

@Repository
public interface LogRepository extends CrudRepository<LogEntity> {
}
