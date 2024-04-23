package com.wellness360.nutrition.category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path="categories")
public interface CategoryRepository extends JpaRepository<CategoryEntity, Integer>{
}
