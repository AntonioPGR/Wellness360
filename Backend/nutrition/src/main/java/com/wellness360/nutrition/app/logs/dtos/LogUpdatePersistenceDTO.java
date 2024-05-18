package com.wellness360.nutrition.app.logs.dtos;

import java.time.LocalDate;

import com.wellness360.nutrition.app.recipe.RecipeEntity;
import com.wellness360.nutrition.common.crud_bases.interfaces.UuidDTO;

import jakarta.annotation.Nonnull;
import lombok.Getter;

@Getter
public class LogUpdatePersistenceDTO implements UuidDTO {
  @Nonnull
  String uuid;
  @Nonnull
  LocalDate date;
  @Nonnull
  Short amount;
  @Nonnull
  RecipeEntity recipe;
  @Nonnull
  String user_uuid;

  public LogUpdatePersistenceDTO(LogUpdateRequestDTO ids_dto, RecipeEntity recipe) {
    this.date = ids_dto.getDate();
    this.amount = ids_dto.getAmount();
    this.recipe = recipe;
    this.user_uuid = ids_dto.getUser_uuid();
  }
  
}
