package com.wellness360.nutrition.app.selectivity.restriction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wellness360.nutrition.app.selectivity.SelectivityRepository;
import com.wellness360.nutrition.app.selectivity.SelectivityService;
import com.wellness360.nutrition.app.selectivity.dtos.SelectivityCreateEntitiesDTO;
import com.wellness360.nutrition.app.selectivity.dtos.SelectivityReturnDTO;

import jakarta.transaction.Transactional;


@Service
@Transactional
public class RestrictionService extends SelectivityService<RestrictionEntity>{

  @Autowired
  SelectivityRepository<RestrictionEntity> repository;

  @Override
  public RestrictionEntity createDTOtoEntity(SelectivityCreateEntitiesDTO dto) {
    return new RestrictionEntity(dto);
  }

  @Override
  public SelectivityReturnDTO entityToReturnDTO(RestrictionEntity entity) {
    return new SelectivityReturnDTO(entity);
  }

}
