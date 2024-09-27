package com.wellness360.nutrition.app.category;

import com.wellness360.nutrition.app.category.dtos.CategoryReturnDTO;
import com.wellness360.nutrition.app.category.dtos.CategoryUpdateRequestDTO;
import com.wellness360.nutrition.packages.crud.controllers.CrudStorageController;
import com.wellness360.nutrition.app.category.dtos.CategoryCreateRequestDTO;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Validated
@RequestMapping("${path.category}")
public class CategoryController extends CrudStorageController<
  CategoryCreateRequestDTO,
  CategoryUpdateRequestDTO,
  CategoryReturnDTO,
  CategoryService
> {}
