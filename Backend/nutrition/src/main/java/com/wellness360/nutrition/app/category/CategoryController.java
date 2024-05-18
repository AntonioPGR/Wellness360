package com.wellness360.nutrition.app.category;

import com.wellness360.nutrition.app.category.dtos.CategoryReturnDTO;
import com.wellness360.nutrition.app.category.dtos.CategoryUpdateRequestDTO;
import com.wellness360.nutrition.app.category.dtos.CategoryCreateRequestDTO;
import com.wellness360.nutrition.common.crud_bases.CrudImageController;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/category")
public class CategoryController extends CrudImageController<
  CategoryCreateRequestDTO,
  CategoryUpdateRequestDTO,
  CategoryReturnDTO,
  CategoryService
> {}
