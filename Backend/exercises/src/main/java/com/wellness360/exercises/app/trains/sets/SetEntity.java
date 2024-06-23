package com.wellness360.exercises.app.trains.sets;

import java.util.List;

import com.wellness360.exercises.app.exercises.ExerciseEntity;
import com.wellness360.exercises.app.train_log.sets.SetLogEntity;
import com.wellness360.exercises.app.trains.TrainEntity;
import com.wellness360.exercises.packages.crud.entities.UniqueIdentifierEntity;

import jakarta.annotation.Nullable;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "sets")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SetEntity extends UniqueIdentifierEntity {
  
  @Nullable
  Short weight;

  @Nullable
  Short reps;

  @Nullable
  Short minutes;

  // RELATIONSHIPS
  @ManyToOne
  @JoinColumn(
    name = "train_id",
    nullable = false
  )
  TrainEntity train;

  @ManyToOne
  @JoinColumn(
    name = "exercise_id",
    nullable = false
  )
  ExerciseEntity exercise;

  @OneToMany(mappedBy = "sets")
  List<SetLogEntity> set_log;

}
