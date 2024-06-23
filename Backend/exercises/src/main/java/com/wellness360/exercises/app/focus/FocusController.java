package com.wellness360.exercises.app.focus;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wellness360.exercises.app.focus.dtos.FocusCreateRequestDTO;
import com.wellness360.exercises.app.focus.dtos.FocusReturnDTO;
import com.wellness360.exercises.app.focus.dtos.FocusUpdateRequestDTO;
import com.wellness360.exercises.packages.crud.controllers.CrudController;


@RestController
@RequestMapping("/focus")
public class FocusController extends CrudController<
  FocusCreateRequestDTO,
  FocusUpdateRequestDTO,
  FocusReturnDTO,
  FocusService
> {
}
