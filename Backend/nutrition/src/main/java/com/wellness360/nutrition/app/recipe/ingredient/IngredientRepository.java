package com.wellness360.nutrition.app.recipe.ingredient;

import org.springframework.stereotype.Repository;

import com.wellness360.nutrition.common.crud_bases.repositories.UUIDRepository;

@Repository
public interface IngredientRepository extends UUIDRepository<IngredientEntity> {
}
