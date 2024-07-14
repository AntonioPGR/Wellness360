package com.wellness360.exercises.app.train_log.exercise;

import java.util.List;

import com.wellness360.exercises.app.exercises.ExerciseEntity;
import com.wellness360.exercises.app.train_log.TrainLogEntity;
import com.wellness360.exercises.app.train_log.sets.SetLogEntity;
import com.wellness360.exercises.packages.crud.entities.UniqueIdentifierEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "exercises_logs")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ExerciseLogEntity extends UniqueIdentifierEntity{
  
  @ManyToOne
  @JoinColumn(
    name = "exercise_id",
    nullable = false
  )
  ExerciseEntity exercise;

  @ManyToOne
  @JoinColumn(
    name = "train_log_id",
    nullable = false
  )
  TrainLogEntity train_log;

  @OneToMany(mappedBy = "exercise_log")
  List<SetLogEntity> set_logs;

  public ExerciseLogEntity(ExerciseEntity exercise, TrainLogEntity train_log){
    this.exercise = exercise;
    this.train_log = train_log;
  }

}
