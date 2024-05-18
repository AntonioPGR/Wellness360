package com.wellness360.nutrition.app.food;

import org.springframework.stereotype.Repository;

import com.wellness360.nutrition.common.crud_bases.repositories.UUIDRepository;

@Repository
public interface FoodRepository extends UUIDRepository<FoodEntity> {
}
