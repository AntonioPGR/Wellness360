package com.wellness360.nutrition.category;

import com.wellness360.common.services.FullCrudService;
import com.wellness360.nutrition.category.dtos.*;
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

  protected CategoryReturnDTO createReturnDTO(CategoryEntity entity){
    return new CategoryReturnDTO(entity);
  };

  protected CategoryEntity createEntity(CategoryCreateDTO dto){
    return new CategoryEntity(dto);
  };

  protected String getDefaultURL(){
    return "http://localhost:8080/categories";
  };

}
