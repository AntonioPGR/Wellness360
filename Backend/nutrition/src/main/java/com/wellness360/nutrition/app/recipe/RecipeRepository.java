package com.wellness360.nutrition.app.recipe;

import org.springframework.stereotype.Repository;

import com.wellness360.nutrition.common.repositories.UUIDRepository;

@Repository
public interface RecipeRepository extends UUIDRepository<RecipeEntity> {
}
