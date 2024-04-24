package com.wellness360.nutrition.category;

import com.wellness360.common.crud_default.CrudService;
import com.wellness360.nutrition.category.dtos.*;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class CategoryService extends CrudService<
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
    return "https://localhost:8080";
  };

}
