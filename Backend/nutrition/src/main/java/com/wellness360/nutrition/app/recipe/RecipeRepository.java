package com.wellness360.nutrition.app.recipe;

import org.springframework.stereotype.Repository;
import com.wellness360.nutrition.packages.crud.repositories.CrudRepository;

@Repository
public interface RecipeRepository extends CrudRepository<RecipeEntity> {
}
