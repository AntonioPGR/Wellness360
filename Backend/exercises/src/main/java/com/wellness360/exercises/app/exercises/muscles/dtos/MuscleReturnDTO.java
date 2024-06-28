package com.wellness360.exercises.app.exercises.muscles.dtos;

import com.wellness360.exercises.app.exercises.muscles.MuscleEntity;
import com.wellness360.exercises.enums.BodyMusclesEnum;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class MuscleReturnDTO {
  
  String muscle;
  String image_url;

  public MuscleReturnDTO(MuscleEntity muscle) {
    this.muscle = muscle.getMuscle();
    this.image_url = BodyMusclesEnum.valueOf(muscle.getMuscle()).getImageUrl();
  }

}
