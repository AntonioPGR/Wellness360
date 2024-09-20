package com.wellness360.nutrition.app.category;

import org.springframework.stereotype.Repository;

import com.wellness360.nutrition.packages.crud.repositories.CrudRepository;

@Repository
public interface CategoryRepository extends CrudRepository<CategoryEntity>{
}
