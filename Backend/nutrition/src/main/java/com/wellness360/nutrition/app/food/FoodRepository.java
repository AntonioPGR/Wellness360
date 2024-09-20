package com.wellness360.nutrition.app.food;

import org.springframework.stereotype.Repository;

import com.wellness360.nutrition.packages.crud.repositories.CrudRepository;

@Repository
public interface FoodRepository extends CrudRepository<FoodEntity> {
}
