package com.wellness360.nutrition.app.food;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wellness360.nutrition.app.food.dtos.FoodCreateIdsDTO;
import com.wellness360.nutrition.app.food.dtos.FoodReturnDTO;
import com.wellness360.nutrition.app.food.dtos.FoodUpdateIdsDTO;
import com.wellness360.nutrition.common.CrudBases.CrudController;

@RestController
@RequestMapping("${path.food}")
public class FoodController extends CrudController<
  FoodCreateIdsDTO,
  FoodUpdateIdsDTO,
  FoodReturnDTO,
  FoodService
>{

  @Autowired
  FoodService service;

  @Override
  public FoodReturnDTO createEntity(FoodCreateIdsDTO dto) {
    return service.create(dto);
  }

  @Override
  public Optional<FoodReturnDTO> updateEntity(FoodUpdateIdsDTO dto) {
    return service.update(dto);
  }

}
