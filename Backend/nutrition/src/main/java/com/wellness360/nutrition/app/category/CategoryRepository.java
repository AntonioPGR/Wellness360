package com.wellness360.nutrition.app.category;

import org.springframework.stereotype.Repository;

import com.wellness360.nutrition.common.repositories.UUIDRepository;


@Repository
public interface CategoryRepository extends UUIDRepository<CategoryEntity>{
}
