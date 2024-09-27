package com.wellness360.nutrition.app.category.dtos;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.wellness360.nutrition.app.category.CategoryEntity;

@Mapper
public interface CategoryMapper {
  
  CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

  CategoryCreatePersistenceDTO createRequestToPersistence(CategoryCreateRequestDTO dto, String image_url);

  CategoryReturnDTO entityToReturn(CategoryEntity entity);

  CategoryUpdatePersistenceDTO updateRequestToPersistence(CategoryUpdateRequestDTO dto, String image_url);

  @Mapping(ignore = true, target = "preferences")
  @Mapping(ignore = true, target = "recipes")
  @Mapping(ignore = true, target = "restricions")
  @Mapping(ignore = true, target = "food")
  CategoryEntity createPersistenceToEntity(CategoryCreatePersistenceDTO dto);

}
