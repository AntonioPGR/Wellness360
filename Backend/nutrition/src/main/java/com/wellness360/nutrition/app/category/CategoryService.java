package com.wellness360.nutrition.app.category;

import com.wellness360.nutrition.app.category.dtos.*;
import com.wellness360.nutrition.common.CrudBases.CrudService;

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

  // INHERIT
  public CategoryReturnDTO entityToReturnDTO(CategoryEntity entity){
    return new CategoryReturnDTO(entity);
  };
  public CategoryEntity createDTOtoEntity(CategoryCreateDTO dto){
    return new CategoryEntity(dto);
  };

}
