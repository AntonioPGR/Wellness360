package com.wellness360.nutrition.app.food;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wellness360.nutrition.app.food.dtos.FoodCreateRequestDTO;
import com.wellness360.nutrition.app.food.dtos.FoodReturnDTO;
import com.wellness360.nutrition.app.food.dtos.FoodUpdateRequestDTO;
import com.wellness360.nutrition.packages.crud.controllers.CrudStorageController;


@RestController
@RequestMapping("${path.food}")
public class FoodController extends CrudStorageController<
  FoodCreateRequestDTO,
  FoodUpdateRequestDTO,
  FoodReturnDTO,
  FoodService
>{}
