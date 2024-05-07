package com.wellness360.nutrition.app.selectivity.restriction;

import org.springframework.stereotype.Service;

import com.wellness360.nutrition.app.selectivity.SelectivityService;
import com.wellness360.nutrition.app.selectivity.dtos.SelectivityCreateEntitiesDTO;

import jakarta.transaction.Transactional;


@Service
@Transactional
public class RestrictionService extends SelectivityService<RestrictionEntity>{

  public RestrictionEntity create(SelectivityCreateEntitiesDTO dto){
    return new RestrictionEntity(dto);
  };

}
