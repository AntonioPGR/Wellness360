package com.wellness360.exercises.app.exercises;

import java.util.List;
import java.util.Objects;

import com.wellness360.exercises.app.exercises.dtos.ExerciseCreatePersistenceDTO;
import com.wellness360.exercises.app.exercises.dtos.ExerciseUpdatePersistenceDTO;
import com.wellness360.exercises.app.exercises.equipments.EquipmentEntity;
import com.wellness360.exercises.app.exercises.muscles.MuscleEntity;
import com.wellness360.exercises.app.train_log.exercise.ExerciseLogEntity;
import com.wellness360.exercises.app.trains.TrainEntity;
import com.wellness360.exercises.app.trains.sets.SetEntity;
import com.wellness360.exercises.packages.crud.entities.NamedDescribedImageEntity;
import com.wellness360.exercises.packages.storage.services.interfaces.INameEntity;

import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "exercises")
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ExerciseEntity extends NamedDescribedImageEntity implements INameEntity<ExerciseUpdatePersistenceDTO> {
  
  @Nonnull
  @Size(max = 25)
  String category;

  @Nullable
  @Size(max = 255)
  String video_url;

  // RELATIONSHIPS
  @ManyToMany(mappedBy = "exercises")
  List<TrainEntity> trains;

  @OneToMany(mappedBy = "exercise")
  List<SetEntity> sets;

  @OneToMany(mappedBy = "exercise")
  List<ExerciseLogEntity> exercise_logs;

  @OneToMany(mappedBy = "exercise")
  @Column(name = "exercise_muscles")
  List<MuscleEntity> muscles;

  @ManyToMany
  @JoinTable(
    name = "exercises_equipments",
    joinColumns = @JoinColumn(name="exercise_id"),
    inverseJoinColumns = @JoinColumn(name="equipment_id")
  )
  List<EquipmentEntity> equipments;

  public ExerciseEntity(ExerciseCreatePersistenceDTO dto) {
    name = dto.getName();
    description = dto.getDescription();
    image_url = dto.getImage_url();
    category = dto.getCategory();
    video_url = dto.getVideo_url();
    muscles = dto.getMuscle();
    equipments = dto.getEquipment();
  }

  public void update(ExerciseUpdatePersistenceDTO dto) {
    name = Objects.requireNonNullElse(dto.getName(), name);
    description = Objects.requireNonNullElse(dto.getDescription(), description);
    image_url = Objects.requireNonNullElse(dto.getImage_url(), image_url);
    category = Objects.requireNonNullElse(dto.getCategory(), category);
    video_url = Objects.requireNonNullElse(dto.getVideo_url(), video_url);
    muscles = Objects.requireNonNullElse(dto.getMuscle(), muscles);
    equipments = Objects.requireNonNullElse(dto.getEquipment(), equipments);
  }


}
