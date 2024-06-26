package com.wellness360.nutrition.app.logs;

import org.springframework.stereotype.Repository;

import com.wellness360.nutrition.common.repositories.UUIDRepository;

@Repository
public interface LogRepository extends UUIDRepository<LogEntity> {
}
