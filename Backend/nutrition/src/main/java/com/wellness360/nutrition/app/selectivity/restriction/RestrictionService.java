package com.wellness360.nutrition.app.selectivity.restriction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wellness360.nutrition.app.selectivity.SelectivityRepository;
import com.wellness360.nutrition.app.selectivity.SelectivityService;
import com.wellness360.nutrition.app.selectivity.dtos.SelectivityCreatePersistenceDTO;
import com.wellness360.nutrition.app.selectivity.dtos.SelectivityMapper;

import jakarta.transaction.Transactional;


@Service
@Transactional
public class RestrictionService extends SelectivityService<RestrictionEntity>{

  @Autowired
  SelectivityRepository<RestrictionEntity> repository;

  public RestrictionEntity persistenceToEntity(SelectivityCreatePersistenceDTO dto) {
    return SelectivityMapper.INSTANCE.createPersistenceToRestriction(dto);
  }

}
