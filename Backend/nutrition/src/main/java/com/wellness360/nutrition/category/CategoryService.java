package com.wellness360.nutrition.category;

import com.wellness360.common.services.FullCrudService;
import com.wellness360.nutrition.category.dtos.*;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class CategoryService extends FullCrudService<
  CategoryRepository,
  CategoryCreateDTO,
  CategoryUpdateDTO,
  CategoryReturnDTO,
  CategoryEntity
> {

  @Value("${url.category}")
  String default_url;

  // INHERIT
  protected CategoryReturnDTO createReturnDTO(CategoryEntity entity){
    return new CategoryReturnDTO(entity);
  };
  protected CategoryEntity createEntity(CategoryCreateDTO dto){
    return new CategoryEntity(dto);
  };
  @Override
  protected String getReturnURL(String uuid) {
    return default_url + "/" + uuid;
  }

}
