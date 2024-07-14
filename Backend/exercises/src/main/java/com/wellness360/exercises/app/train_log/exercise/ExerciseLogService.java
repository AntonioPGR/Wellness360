package com.wellness360.exercises.app.train_log.exercise;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wellness360.exercises.app.exercises.ExerciseEntity;
import com.wellness360.exercises.app.train_log.TrainLogEntity;
import com.wellness360.exercises.app.train_log.exercise.dtos.ExerciseLogCreateDTO;
import com.wellness360.exercises.app.train_log.exercise.dtos.ExerciseLogReturnDTO;
import com.wellness360.exercises.app.train_log.sets.SetLogService;
import com.wellness360.exercises.app.train_log.sets.dtos.SetLogReturnDTO;
import com.wellness360.exercises.tools.EntityRetriever;

@Service
public class ExerciseLogService {

  @Autowired
  ExerciseLogRepository repository;
  @Autowired
  EntityRetriever entity_retriever;
  @Autowired
  SetLogService set_log_service;

  public ExerciseLogReturnDTO create(ExerciseLogCreateDTO exercise_dto, TrainLogEntity train_log) {
    ExerciseEntity exercise = entity_retriever.getExerciseByUuid(exercise_dto.getExercise_uuid());
    ExerciseLogEntity entity = new ExerciseLogEntity(exercise, train_log);
    repository.saveAndFlush(entity);
    List<SetLogReturnDTO> sets_logs = exercise_dto.getSets().stream().map(set -> set_log_service.create(set, entity)).toList();
    return new ExerciseLogReturnDTO(exercise.getUuid(), sets_logs);
  }
  
}
