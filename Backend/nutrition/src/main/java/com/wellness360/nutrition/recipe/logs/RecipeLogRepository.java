package com.wellness360.nutrition.recipe.logs;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeLogRepository extends JpaRepository<RecipeLogEntity, Integer> {
}
