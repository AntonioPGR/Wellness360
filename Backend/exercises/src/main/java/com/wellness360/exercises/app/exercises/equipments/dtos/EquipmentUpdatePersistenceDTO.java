package com.wellness360.exercises.app.exercises.equipments.dtos;

import com.wellness360.exercises.packages.crud.dtos.CrudUpdatePersistenceDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EquipmentUpdatePersistenceDTO extends CrudUpdatePersistenceDTO {

  String uuid;
  String name;
  String description;
  String image_url;

  public EquipmentUpdatePersistenceDTO(EquipmentUpdateRequestDTO request_dto, String image_url) {
    this.name = request_dto.getName();
    this.description = request_dto.getDescription();
    this.image_url = image_url;
  }

}
