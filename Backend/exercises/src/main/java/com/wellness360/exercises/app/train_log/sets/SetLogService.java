package com.wellness360.exercises.app.train_log.sets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wellness360.exercises.app.train_log.exercise.ExerciseLogEntity;
import com.wellness360.exercises.app.train_log.sets.dtos.SetLogCreateDTO;
import com.wellness360.exercises.app.train_log.sets.dtos.SetLogReturnDTO;
import com.wellness360.exercises.app.trains.sets.SetEntity;
import com.wellness360.exercises.tools.EntityRetriever;

@Service
public class SetLogService {

  @Autowired
  SetLogRepository repository;
  @Autowired
  EntityRetriever entity_retriever;

  public SetLogReturnDTO create(SetLogCreateDTO dto, ExerciseLogEntity exercise) {
    SetEntity set = entity_retriever.getSetByUuid(dto.getUuid());
    SetLogEntity entity = new SetLogEntity(dto, exercise, set);
    repository.saveAndFlush(entity);
    return new SetLogReturnDTO(entity);
  }
  
}
