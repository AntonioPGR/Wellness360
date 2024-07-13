package com.wellness360.exercises.app.exercises.dtos;

import java.util.List;

import com.wellness360.exercises.app.exercises.equipments.EquipmentEntity;
import com.wellness360.exercises.packages.crud.dtos.CrudCreatePersistenceDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ExerciseCreatePersistenceDTO extends CrudCreatePersistenceDTO {
  
  String name;
  String description;
  String image_url;
  String category;
  String video_url;
  List<EquipmentEntity> equipments;
  
  public ExerciseCreatePersistenceDTO(ExerciseCreateRequestDTO request_dto, String image_url, String video_url, List<EquipmentEntity> equipments) {
    this.name = request_dto.name;
    this.description = request_dto.description;
    this.image_url = image_url;
    this.category = request_dto.category;
    this.video_url = video_url;
    this.equipments = equipments;
  }

}
