package com.wellness360.nutrition.food;

import java.net.URI;
import java.util.Optional;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wellness360.common.controllers.FullCrudController;
import com.wellness360.nutrition.food.dtos.FoodCreateIdsDTO;
import com.wellness360.nutrition.food.dtos.FoodReturnDTO;
import com.wellness360.nutrition.food.dtos.FoodUpdateIdsDTO;

@RestController
@RequestMapping("/food")
public class FoodController extends FullCrudController<
  FoodService,
  FoodCreateIdsDTO,
  FoodUpdateIdsDTO,
  FoodReturnDTO
>{

  @Override
  protected Optional<URI> createEntity(FoodCreateIdsDTO create_dto) {
    return service.create(create_dto);
  }

  @Override
  protected Optional<FoodReturnDTO> updateEntity(FoodUpdateIdsDTO update_dto) {
    return service.update(update_dto);
  }
  
}
