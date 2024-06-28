package com.wellness360.exercises.app.injuries;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wellness360.exercises.app.injuries.dtos.InjuryCreateRequestDTO;
import com.wellness360.exercises.app.injuries.dtos.InjuryReturnDTO;
import com.wellness360.exercises.app.injuries.dtos.InjuryUpdateRequestDTO;
import com.wellness360.exercises.packages.crud.controllers.CrudController;

@RestController
@RequestMapping("${path.injuries}")
public class InjuryController extends CrudController<
  InjuryCreateRequestDTO,
  InjuryUpdateRequestDTO,
  InjuryReturnDTO,
  InjuryService
> {

  @GetMapping("/user/{uuid}")
  public ResponseEntity<List<InjuryReturnDTO>> getByUser(@PathVariable("uuid") String uuid) {
    List<InjuryReturnDTO> return_dto = service.getByUserUuid(uuid);
    return ResponseEntity.ok().body(return_dto);
  }
  
}
