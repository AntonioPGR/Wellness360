package com.wellness360.exercises.app.exercises.muscles;

import com.wellness360.exercises.app.exercises.ExerciseEntity;
import com.wellness360.exercises.enums.BodyMusclesEnum;
import com.wellness360.exercises.packages.crud.entities.UniqueIdentifierEntity;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "exercises_muscles")
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class MuscleEntity extends UniqueIdentifierEntity {
  
  @Nonnull
  @Size(max = 25)
  String muscle;

  // RELATIONSHIPS
  @ManyToOne
  @JoinColumn(
    name = "exercise_id",
    nullable = false
  )
  ExerciseEntity exercise;

  public MuscleEntity(BodyMusclesEnum muscle) {
    this.muscle = muscle.name();
  }

}
