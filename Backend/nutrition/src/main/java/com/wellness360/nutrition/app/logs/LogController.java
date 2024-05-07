package com.wellness360.nutrition.app.logs;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.wellness360.nutrition.app.logs.dtos.LogCreateIdsDTO;
import com.wellness360.nutrition.app.logs.dtos.LogReturnDTO;
import com.wellness360.nutrition.app.logs.dtos.LogUpdateIdsDTO;
import com.wellness360.nutrition.common.CrudBases.CrudController;

public class LogController extends CrudController<
  LogCreateIdsDTO,
  LogUpdateIdsDTO,
  LogReturnDTO,
  LogService
>{

  @Autowired
  LogService service;

  @Override
  public LogReturnDTO createEntity(LogCreateIdsDTO dto) {
    return service.create(dto);
  }

  @Override
  public Optional<LogReturnDTO> updateEntity(LogUpdateIdsDTO dto) {
    return service.update(dto);
  }
  
}
