package com.wellness360.exercises.app.exercises.equipments;

import java.util.Objects;
import java.util.Set;

import com.wellness360.exercises.app.exercises.ExerciseEntity;
import com.wellness360.exercises.app.exercises.equipments.dtos.EquipmentCreatePersistenceDTO;
import com.wellness360.exercises.app.exercises.equipments.dtos.EquipmentUpdatePersistenceDTO;
import com.wellness360.exercises.packages.crud.entities.NamedDescribedImageEntity;
import com.wellness360.exercises.packages.storage.services.interfaces.IStorageEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "equipments")
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class EquipmentEntity extends NamedDescribedImageEntity implements IStorageEntity<EquipmentUpdatePersistenceDTO> {

  @ManyToMany(mappedBy = "equipments")
  Set<ExerciseEntity> exercises;

  public EquipmentEntity(EquipmentCreatePersistenceDTO dto) {
    name = dto.getName();
    description = dto.getDescription();
    image_url = dto.getImage_url();
  }

  public void update(EquipmentUpdatePersistenceDTO dto) {
    name = Objects.requireNonNullElse(dto.getName(), name);
    description = dto.getDescription() != null? dto.getDescription() :  description;
    image_url = Objects.requireNonNullElse(dto.getImage_url(), image_url);
  }

}
