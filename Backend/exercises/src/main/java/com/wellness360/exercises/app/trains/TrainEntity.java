package com.wellness360.exercises.app.trains;

import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.UUID;

import com.wellness360.exercises.app.exercises.ExerciseEntity;
import com.wellness360.exercises.app.train_log.TrainLogEntity;
import com.wellness360.exercises.app.trains.dtos.TrainCreatePersistenceDTO;
import com.wellness360.exercises.app.trains.dtos.TrainUpdatePersistenceDTO;
import com.wellness360.exercises.app.trains.sets.SetEntity;
import com.wellness360.exercises.packages.crud.entities.UniqueIdentifierEntity;
import com.wellness360.exercises.packages.crud.entities.interfaces.IBaseEntity;

import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "trains")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TrainEntity extends UniqueIdentifierEntity implements IBaseEntity<TrainUpdatePersistenceDTO> {
  
  @UUID
  @Nonnull
  @Size(max = 36, min = 36)
  String user_uuid;

  @Nonnull
  @Max(7)
  @Min(0)
  Short week_day;

  @Nonnull
  @Size(max = 50)
  String name;

  @Nullable
  String description;

  @PastOrPresent
  @Nonnull
  @CreationTimestamp
  Date created_at;

  @PastOrPresent
  @Nonnull
  @CreationTimestamp
  Date updated_at;

  Boolean is_visible;

  // RELATIONSHIPS
  @OneToMany(mappedBy = "train")
  List<TrainLogEntity> train_logs;

  @ManyToMany
  @JoinTable(
    name = "trains_exercises",
    joinColumns = @JoinColumn(name="train_id"),
    inverseJoinColumns = @JoinColumn(name="exercise_id")
  )
  List<ExerciseEntity> exercises;

  @OneToMany(mappedBy = "train")
  List<SetEntity> sets;

  @Override
  public void update(TrainUpdatePersistenceDTO dto) {
    user_uuid = Objects.requireNonNullElse(dto.getUser_uuid(), user_uuid);
    week_day = Objects.requireNonNullElse(dto.getWeek_day(), week_day);
    name = Objects.requireNonNullElse(dto.getName(), name);
    description = Objects.requireNonNullElse(dto.getDescription(), description);
  }

  public TrainEntity(TrainCreatePersistenceDTO dto) {
    user_uuid = dto.getUser_uuid();
    week_day = dto.getWeek_day().shortValue();
    name = dto.getDescription();
    description = dto.getDescription();
  }


}
