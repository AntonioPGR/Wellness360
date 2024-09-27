package com.wellness360.nutrition.app.logs;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wellness360.nutrition.app.logs.dtos.LogCreateRequestDTO;
import com.wellness360.nutrition.app.logs.dtos.LogReturnDTO;
import com.wellness360.nutrition.app.logs.dtos.LogUpdateRequestDTO;
import com.wellness360.nutrition.packages.crud.controllers.CrudController;

@RestController
@RequestMapping("${path.log}")
public class LogController extends CrudController<
  LogCreateRequestDTO,
  LogUpdateRequestDTO,
  LogReturnDTO,
  LogService
>{}
