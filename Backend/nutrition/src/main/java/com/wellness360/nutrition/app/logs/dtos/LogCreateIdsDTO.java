package com.wellness360.nutrition.app.logs.dtos;

import java.time.LocalDate;


import jakarta.annotation.Nonnull;
import lombok.Getter;

@Getter
public class LogCreateIdsDTO {
  @Nonnull
  LocalDate date;
  @Nonnull
  Short amount;
  @Nonnull
  String recipe_uuid;
  @Nonnull
  String user_uuid;
}
