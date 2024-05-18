package com.wellness360.nutrition.app.logs.dtos;

import java.time.LocalDate;

import com.wellness360.nutrition.common.crud_bases.interfaces.UuidDTO;

import jakarta.annotation.Nonnull;
import lombok.Getter;

@Getter
public class LogUpdateRequestDTO implements UuidDTO {
  @Nonnull
  String uuid;
  @Nonnull
  LocalDate date;
  @Nonnull
  Short amount;
  @Nonnull
  String recipe_uuid;
  @Nonnull
  String user_uuid;
}
