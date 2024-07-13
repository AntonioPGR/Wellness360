package com.wellness360.exercises.app.exercises.dtos;

import java.util.List;

import com.wellness360.exercises.app.exercises.ExerciseEntity;
import com.wellness360.exercises.app.exercises.equipments.dtos.EquipmentReturnDTO;
import com.wellness360.exercises.app.exercises.muscles.MuscleEntity;
import com.wellness360.exercises.app.exercises.muscles.dtos.MuscleReturnDTO;
import com.wellness360.exercises.packages.crud.dtos.CrudReturnDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ExerciseReturnDTO extends CrudReturnDTO {
  
  String uuid;
  String name;
  String description;
  String image_url;
  String category;
  String video_url;
  List<MuscleReturnDTO> muscles;
  List<EquipmentReturnDTO> equipments;

  public ExerciseReturnDTO(ExerciseEntity entity, List<MuscleEntity> muscles) {
    this.uuid = entity.getUuid();
    this.name = entity.getName();
    this.description = entity.getDescription();
    this.image_url = entity.getImage_url();
    this.category = entity.getCategory();
    this.video_url = entity.getVideo_url();
    this.muscles = muscles.stream().map((muscle) -> new MuscleReturnDTO(muscle)).toList();
    this.equipments = entity.getEquipments().stream().map((equipment) -> new EquipmentReturnDTO(equipment)).toList();
  }

}
