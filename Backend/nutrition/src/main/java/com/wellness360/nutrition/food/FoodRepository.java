package com.wellness360.nutrition.food;

import org.springframework.stereotype.Repository;

import com.wellness360.common.repositories.IdRepository;

@Repository
public interface FoodRepository extends IdRepository<FoodEntity> {
}
