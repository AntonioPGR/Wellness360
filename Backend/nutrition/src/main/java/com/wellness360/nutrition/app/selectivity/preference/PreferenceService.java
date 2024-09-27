package com.wellness360.nutrition.app.selectivity.preference;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wellness360.nutrition.app.selectivity.SelectivityRepository;
import com.wellness360.nutrition.app.selectivity.SelectivityService;
import com.wellness360.nutrition.app.selectivity.dtos.SelectivityCreatePersistenceDTO;
import com.wellness360.nutrition.app.selectivity.dtos.SelectivityMapper;
import jakarta.transaction.Transactional;


@Service
@Transactional
public class PreferenceService extends SelectivityService<PreferenceEntity>{

  @Autowired
  SelectivityRepository<PreferenceEntity> repository;

  public PreferenceEntity persistenceToEntity(SelectivityCreatePersistenceDTO dto){
    return SelectivityMapper.INSTANCE.createPersistenceToPreference(dto);
  }

}
