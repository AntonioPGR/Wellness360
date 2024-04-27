package com.wellness360.nutrition.category;

import com.wellness360.common.controllers.FullCrudController;
import com.wellness360.nutrition.category.dtos.CategoryCreateDTO;
import com.wellness360.nutrition.category.dtos.CategoryReturnDTO;
import com.wellness360.nutrition.category.dtos.CategoryUpdateDTO;

import java.net.URI;
import java.util.Optional;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/categories")
public class CategoryController extends FullCrudController<
  CategoryService,
  CategoryCreateDTO,
  CategoryUpdateDTO,
  CategoryReturnDTO
> {

  @Override
  protected Optional<URI> createEntity(CategoryCreateDTO create_dto) {
    return this.service.create(create_dto);
  }

  @Override
  protected Optional<CategoryReturnDTO> updateEntity(CategoryUpdateDTO update_dto) {
    return this.service.update(update_dto);
  }

}
