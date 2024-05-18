package com.wellness360.nutrition.app.logs;

import com.wellness360.nutrition.app.logs.dtos.LogCreateRequestDTO;
import com.wellness360.nutrition.app.logs.dtos.LogReturnDTO;
import com.wellness360.nutrition.app.logs.dtos.LogUpdateRequestDTO;
import com.wellness360.nutrition.common.crud_bases.CrudController;

public class LogController extends CrudController<
  LogCreateRequestDTO,
  LogUpdateRequestDTO,
  LogReturnDTO,
  LogService
>{}
