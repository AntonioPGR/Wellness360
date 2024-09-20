package com.wellness360.nutrition.app.food.dtos;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.wellness360.nutrition.app.category.CategoryEntity;
import com.wellness360.nutrition.app.category.dtos.CategoryMapper;
import com.wellness360.nutrition.app.food.FoodEntity;
import com.wellness360.nutrition.app.tag.TagEntity;
import com.wellness360.nutrition.app.tag.dtos.TagMapper;

@Mapper(uses = {CategoryMapper.class, TagMapper.class})
public interface FoodMapper {

  FoodMapper INSTANCE = Mappers.getMapper(FoodMapper.class);
  
  @Mapping(source = "dto.name", target = "name")
  @Mapping(source = "dto.description", target = "description")
  @Mapping(source = "image_url", target = "image_url")
  @Mapping(source = "tag", target = "tag")
  FoodCreatePersistenceDTO createRequestToPersistence(FoodCreateRequestDTO dto, FoodNutrientsDTO nutrients, String image_url, TagEntity tag, CategoryEntity category);

  FoodReturnDTO entityToReturn(FoodEntity entity);

  @Mapping(source = "dto.uuid", target = "uuid")
  @Mapping(source = "dto.name", target = "name")
  @Mapping(source = "dto.description", target = "description")
  @Mapping(source = "image_url", target = "image_url")
  @Mapping(source = "tag", target = "tag")
  FoodUpdatePersistenceDTO updateRequestToPersistence(FoodUpdateRequestDTO dto, FoodNutrientsDTO nutrients, String image_url, TagEntity tag, CategoryEntity category);

  
  @Mapping(source="dto.nutrients.calories", target="calories") 
  @Mapping(source="dto.nutrients.carbs", target="carbs") 
  @Mapping(source="dto.nutrients.dietary_fiber", target="dietary_fiber") 
  @Mapping(source="dto.nutrients.fats", target="fats") 
  @Mapping(source="dto.nutrients.proteins", target="proteins") 
  @Mapping(source="dto.nutrients.saturated_fats", target="saturated_fats") 
  @Mapping(source="dto.nutrients.serving_amount", target="serving_amount") 
  @Mapping(source="dto.nutrients.sodium", target="sodium")
  @Mapping(ignore=true, target="recipes") 
  @Mapping(ignore=true, target="restricions") 
  @Mapping(ignore=true, target="preferences") 
  FoodEntity createPersistencetToEntity(FoodCreatePersistenceDTO dto);
  
}
