package com.wellness360.nutrition.app.category;

import com.wellness360.nutrition.app.category.dtos.CategoryCreateDTO;
import com.wellness360.nutrition.app.category.dtos.CategoryReturnDTO;
import com.wellness360.nutrition.app.category.dtos.CategoryUpdateDTO;
import com.wellness360.nutrition.common.CrudBases.NonRelationalCrudController;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/category")
public class CategoryController extends NonRelationalCrudController<
  CategoryCreateDTO,
  CategoryUpdateDTO,
  CategoryReturnDTO,
  CategoryService
> {}
