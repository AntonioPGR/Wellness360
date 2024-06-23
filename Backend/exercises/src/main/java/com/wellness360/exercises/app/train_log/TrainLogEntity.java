package com.wellness360.exercises.app.train_log;

import java.util.Date;
import java.util.List;
import java.util.Objects;

import com.wellness360.exercises.app.train_log.dtos.TrainLogCreatePersistenceDTO;
import com.wellness360.exercises.app.train_log.dtos.TrainLogUpdatePersistenceDTO;
import com.wellness360.exercises.app.train_log.exercise.ExerciseLogEntity;
import com.wellness360.exercises.app.trains.TrainEntity;
import com.wellness360.exercises.packages.crud.entities.UniqueIdentifierEntity;
import com.wellness360.exercises.packages.crud.entities.interfaces.IBaseEntity;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "trains_logs")
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class TrainLogEntity extends UniqueIdentifierEntity implements IBaseEntity<TrainLogUpdatePersistenceDTO> {
  
  @Nonnull
  @Size(max = 36, min = 36)
  String user_uuid;

  @PastOrPresent
  Date date;

  @Min(0)
  Short time_spent;

  // RELATIONSHIPS
  @ManyToOne
  @JoinColumn(
    name = "train_id",
    nullable = false
  )
  TrainEntity train;

  @OneToMany(mappedBy = "train_log")
  List<ExerciseLogEntity> exercises_logs;

  public void update(TrainLogUpdatePersistenceDTO dto) {
    user_uuid = Objects.requireNonNullElse(dto.getUser_uuid(), user_uuid);
    train = Objects.requireNonNullElse(dto.getTrain(), train);
    date = Objects.requireNonNullElse(dto.getDate(), date);
    time_spent = Objects.requireNonNullElse(dto.getTime(), time_spent);
  }

  public TrainLogEntity(TrainLogCreatePersistenceDTO dto) {
    user_uuid = dto.getUser_uuid();
    train = dto.getTrain();
    date = dto.getDate();
    time_spent = dto.getTime();
  }

}
