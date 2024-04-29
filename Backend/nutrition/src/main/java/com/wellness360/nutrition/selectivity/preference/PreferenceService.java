package com.wellness360.nutrition.selectivity.preference;

import org.springframework.stereotype.Service;
import com.wellness360.nutrition.selectivity.SelectivityService;
import com.wellness360.nutrition.selectivity.dtos.SelectivityCreateEntitiesDTO;

import jakarta.transaction.Transactional;


@Service
@Transactional
public class PreferenceService extends SelectivityService<PreferenceEntity>{

  public PreferenceEntity createEntity(SelectivityCreateEntitiesDTO dto){
    return new PreferenceEntity(dto);
  };

}
