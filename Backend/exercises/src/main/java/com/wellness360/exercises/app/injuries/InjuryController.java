package com.wellness360.exercises.app.injuries;

import com.wellness360.exercises.app.injuries.dtos.InjuryCreateRequestDTO;
import com.wellness360.exercises.app.injuries.dtos.InjuryReturnDTO;
import com.wellness360.exercises.app.injuries.dtos.InjuryUpdateRequestDTO;
import com.wellness360.exercises.packages.crud.controllers.CrudController;

public class InjuryController extends CrudController<
  InjuryCreateRequestDTO,
  InjuryUpdateRequestDTO,
  InjuryReturnDTO,
  InjuryService
> {
  
}
