package com.wellness360.nutrition.recipe.recipe_logs;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "log")
public interface RecipeLogRepository extends JpaRepository<RecipeLogEntity, Integer> {
}
