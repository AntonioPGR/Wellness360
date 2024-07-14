package com.wellness360.exercises.tools;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wellness360.exercises.app.exercises.ExerciseEntity;
import com.wellness360.exercises.app.exercises.ExerciseRepository;
import com.wellness360.exercises.app.exercises.equipments.EquipmentEntity;
import com.wellness360.exercises.app.exercises.equipments.EquipmentRepository;
import com.wellness360.exercises.app.train_log.TrainLogEntity;
import com.wellness360.exercises.app.train_log.TrainLogRepository;
import com.wellness360.exercises.app.trains.TrainEntity;
import com.wellness360.exercises.app.trains.TrainRepository;
import com.wellness360.exercises.app.trains.sets.SetEntity;
import com.wellness360.exercises.app.trains.sets.SetRepository;

import jakarta.persistence.EntityNotFoundException;


@Service
public class EntityRetriever {

  @Autowired
  EquipmentRepository equipment;
  @Autowired
  TrainRepository train;
  @Autowired
  ExerciseRepository exercise;
  @Autowired
  TrainLogRepository train_log;
  @Autowired
  SetRepository set;
  
  public EquipmentEntity getEquipmentByUuid(String uuid){
    return equipment.findByUuid(uuid).orElseThrow(() -> new EntityNotFoundException("Could not find any equipment with the passed uuid"));
  }

  public TrainEntity getTrainByUuid(String uuid) {
    return train.findByUuid(uuid).orElseThrow(() -> new EntityNotFoundException("Could not find any equipment with the passed uuid"));
  }

  public ExerciseEntity getExerciseByUuid(String uuid) {
    return exercise.findByUuid(uuid).orElseThrow(() -> new EntityNotFoundException("Could not find any exercise with the passed uuid"));
  }

  public TrainLogEntity getTrainLogByUuid(String uuid) {
    return train_log.findByUuid(uuid).orElseThrow(() -> new EntityNotFoundException("Could not find any train log with the passed uuid"));
  }

  public SetEntity getSetByUuid(String uuid) {
    return set.findByUuid(uuid).orElseThrow(() -> new EntityNotFoundException("Could not find any set log with the passed uuid"));
  }

}
