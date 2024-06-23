package com.wellness360.exercises.app.exercises.equipments.dtos;

import com.wellness360.exercises.app.exercises.equipments.EquipmentEntity;
import com.wellness360.exercises.packages.crud.dtos.CrudReturnDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class EquipmentReturnDTO extends CrudReturnDTO {

  String uuid;
  String name;
  String description;
  String image_url;

  public EquipmentReturnDTO(EquipmentEntity entity) {
    this.uuid = entity.getUuid();
    this.name = entity.getName();
    this.description = entity.getDescription();
    this.image_url = entity.getImage_url();
  }

}
