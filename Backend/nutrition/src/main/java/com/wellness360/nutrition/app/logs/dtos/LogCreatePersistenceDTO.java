package com.wellness360.nutrition.app.logs.dtos;

import java.time.LocalDate;

import com.wellness360.nutrition.app.recipe.RecipeEntity;

import jakarta.annotation.Nonnull;
import lombok.Getter;

@Getter
public class LogCreatePersistenceDTO {
  @Nonnull
  LocalDate date;
  @Nonnull
  Short amount;
  @Nonnull
  RecipeEntity recipe;
  @Nonnull
  String user_uuid;
  
  public LogCreatePersistenceDTO(LogCreateRequestDTO ids_dto, RecipeEntity recipe) {
    this.date = ids_dto.getDate();
    this.amount = ids_dto.getAmount();
    this.recipe = recipe;
    this.user_uuid = ids_dto.getUser_uuid();
  }

}
