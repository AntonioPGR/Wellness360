package com.wellness360.nutrition.category;

import com.wellness360.common.crud_default.CrudController;
import com.wellness360.nutrition.category.dtos.CategoryCreateDTO;
import com.wellness360.nutrition.category.dtos.CategoryReturnDTO;
import com.wellness360.nutrition.category.dtos.CategoryUpdateDTO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/categories")
public class CategoryController extends CrudController<
  CategoryService,
  CategoryCreateDTO,
  CategoryUpdateDTO,
  CategoryReturnDTO
> {}
