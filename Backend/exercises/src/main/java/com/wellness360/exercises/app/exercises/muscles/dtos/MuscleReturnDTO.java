package com.wellness360.exercises.app.exercises.muscles.dtos;

import com.wellness360.exercises.app.exercises.muscles.MuscleEntity;
import com.wellness360.exercises.enums.BodyMusclesEnum;
import com.wellness360.exercises.packages.crud.dtos.interfaces.ValidatableDTO;
import com.wellness360.exercises.packages.storage.settings.StorageFolders;
import com.wellness360.exercises.packages.validation.ValidateService;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class MuscleReturnDTO implements ValidatableDTO {
  
  String muscle;
  String image_url;

  public void validate(ValidateService validator) {
    throw new UnsupportedOperationException("Unimplemented method 'validate'");
  }

  public MuscleReturnDTO(MuscleEntity muscle) {
    this.muscle = muscle.getMuscle();
    this.image_url = StorageFolders.muscles.name() + "/" + BodyMusclesEnum.valueOf(muscle.getMuscle()).getImageUrl();
  }

}
