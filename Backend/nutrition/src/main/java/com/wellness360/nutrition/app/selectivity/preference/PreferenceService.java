package com.wellness360.nutrition.app.selectivity.preference;

import org.springframework.stereotype.Service;

import com.wellness360.nutrition.app.selectivity.SelectivityService;
import com.wellness360.nutrition.app.selectivity.dtos.SelectivityCreateEntitiesDTO;

import jakarta.transaction.Transactional;


@Service
@Transactional
public class PreferenceService extends SelectivityService<PreferenceEntity>{

  public PreferenceEntity create(SelectivityCreateEntitiesDTO dto){
    return new PreferenceEntity(dto);
  };

}
