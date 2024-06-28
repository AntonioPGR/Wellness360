package com.wellness360.exercises.app.train_log.sets;

import com.wellness360.exercises.app.train_log.exercise.ExerciseLogEntity;
import com.wellness360.exercises.app.trains.sets.SetEntity;
import com.wellness360.exercises.packages.crud.entities.UniqueIdentifierEntity;

import jakarta.annotation.Nullable;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "sets_logs")
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class SetLogEntity extends UniqueIdentifierEntity {
  
  @Nullable
  Short weight;

  @Nullable
  Short reps;

  @Nullable
  Short minutes;

  // RELATIONSHIPS
  @ManyToOne
  @JoinColumn(
    name = "set_id",
    nullable = false
  )
  SetEntity sets;

  @ManyToOne
  @JoinColumn(
    name = "exercise_log_id",
    nullable = false
  )
  ExerciseLogEntity exercise_log;

}