package com.wellness360.nutrition.selectivity.restriction;

import org.springframework.stereotype.Service;
import com.wellness360.nutrition.selectivity.SelectivityService;
import com.wellness360.nutrition.selectivity.dtos.SelectivityCreateEntitiesDTO;

import jakarta.transaction.Transactional;


@Service
@Transactional
public class RestrictionService extends SelectivityService<RestrictionEntity>{

  public RestrictionEntity createEntity(SelectivityCreateEntitiesDTO dto){
    return new RestrictionEntity(dto);
  };

}
