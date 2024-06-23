package com.wellness360.exercises.app.exercises.dtos;

import java.util.List;

import com.wellness360.exercises.app.exercises.equipments.EquipmentEntity;
import com.wellness360.exercises.app.exercises.muscles.MuscleEntity;
import com.wellness360.exercises.packages.crud.dtos.CrudUpdatePersistenceDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ExerciseUpdatePersistenceDTO extends CrudUpdatePersistenceDTO {
  
  String uuid;
  String name;
  String description;
  String image_url;
  String category;
  String video_url;
  List<MuscleEntity> muscle;
  List<EquipmentEntity> equipment;

  public ExerciseUpdatePersistenceDTO(ExerciseUpdateRequestDTO request_dto, String file_name, List<MuscleEntity> muscles, List<EquipmentEntity> equipments) {
    this.uuid = request_dto.uuid;
    this.name = request_dto.name;
    this.description = request_dto.description;
    this.image_url = file_name;
    this.category = request_dto.category;
    this.video_url = "";
    this.muscle = muscles;
    this.equipment = equipments;
  }

}
