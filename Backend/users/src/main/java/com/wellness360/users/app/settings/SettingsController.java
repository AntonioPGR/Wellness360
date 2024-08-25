package com.wellness360.users.app.settings;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wellness360.users.app.settings.dtos.SettingsReturnDTO;
import com.wellness360.users.app.settings.dtos.SettingsUpdateDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("${path.settings}")
public class SettingsController {
  
  @Autowired
  SettingsService service;

  @GetMapping
  public ResponseEntity<SettingsReturnDTO> get() {
    SettingsReturnDTO return_dto = service.getByUser();
    return ResponseEntity.ok(return_dto);
  }

  @PutMapping
  public ResponseEntity<SettingsReturnDTO> update(@RequestBody SettingsUpdateDTO dto) {
    SettingsReturnDTO return_dto = service.update(dto);
    return ResponseEntity.ok(return_dto);
  }

}
