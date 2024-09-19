package com.wellness360.nutrition.app.recipe.ingredient;

import org.springframework.stereotype.Repository;

import com.wellness360.nutrition.packages.crud.repositories.CrudRepository;


@Repository
public interface IngredientRepository extends CrudRepository<IngredientEntity> {
}
