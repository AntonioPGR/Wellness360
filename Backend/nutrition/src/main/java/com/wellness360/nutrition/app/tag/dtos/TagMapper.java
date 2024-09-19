package com.wellness360.nutrition.app.tag.dtos;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.wellness360.nutrition.app.category.CategoryEntity;
import com.wellness360.nutrition.app.tag.TagEntity;

@Mapper
public interface TagMapper {
  
  TagMapper INSTANCE = Mappers.getMapper(TagMapper.class);

  TagReturnCompleteDTO entityToReturn(TagEntity entity);
  TagReturnSimplifiedDTO entityToReturnSimplified(TagEntity entity);

  @Mapping(source = "dto.name", target = "name")
  @Mapping(source = "dto.description", target = "description")
  @Mapping(source = "category", target = "category")
  @Mapping(source = "image_url", target = "image_url")
  TagCreatePersistenceDTO createRequestToPersistence(TagCreateRequestDTO dto, String image_url, CategoryEntity category);

  @Mapping(source = "dto.uuid", target = "uuid")
  @Mapping(source = "dto.name", target = "name")
  @Mapping(source = "dto.description", target = "description")
  @Mapping(source = "category", target = "category")
  @Mapping(source = "image_url", target = "image_url")
  TagUpdatePersistenceDTO updateRequestToPersistence(TagUpdateRequestDTO dto, String image_url, CategoryEntity category);

  @Mapping(ignore = true, target = "foods")
  @Mapping(ignore = true, target = "recipes")
  @Mapping(target = "category", source = "dto.category")
  TagEntity createPersistenceToEntity(TagCreatePersistenceDTO dto);

}
