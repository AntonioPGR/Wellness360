package com.wellness360.exercises.app.focus;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wellness360.exercises.app.focus.dtos.FocusCreateRequestDTO;
import com.wellness360.exercises.app.focus.dtos.FocusReturnDTO;
import com.wellness360.exercises.app.focus.dtos.FocusUpdateRequestDTO;
import com.wellness360.exercises.packages.crud.controllers.CrudController;


@RestController
@RequestMapping("${path.focus}")
public class FocusController extends CrudController<
  FocusCreateRequestDTO,
  FocusUpdateRequestDTO,
  FocusReturnDTO,
  FocusService
> {

  @GetMapping("/user/{uuid}")
  public ResponseEntity<List<FocusReturnDTO>> getByUser(@PathVariable("uuid") String uuid) {
    List<FocusReturnDTO> return_dto = service.getByUserUuid(uuid);
    return ResponseEntity.ok().body(return_dto);
  }

}
