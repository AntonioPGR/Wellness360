package com.wellness360.nutrition.category;

import com.wellness360.common.controllers.FullCrudController;
import com.wellness360.nutrition.category.dtos.CategoryCreateDTO;
import com.wellness360.nutrition.category.dtos.CategoryReturnDTO;
import com.wellness360.nutrition.category.dtos.CategoryUpdateDTO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("${path.category}")
public class CategoryController extends FullCrudController<
  CategoryService,
  CategoryCreateDTO,
  CategoryUpdateDTO,
  CategoryReturnDTO
> {}
