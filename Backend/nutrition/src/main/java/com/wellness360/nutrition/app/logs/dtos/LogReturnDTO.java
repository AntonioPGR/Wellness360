package com.wellness360.nutrition.app.logs.dtos;

import java.time.LocalDate;

import com.wellness360.nutrition.app.logs.LogEntity;
import com.wellness360.nutrition.app.recipe.dtos.RecipeReturnDTO;
import com.wellness360.nutrition.common.dtos.UuidDTO;

import jakarta.annotation.Nonnull;
import lombok.Getter;

@Getter
public class LogReturnDTO implements UuidDTO {
  @Nonnull
  String uuid;
  @Nonnull
  LocalDate date;
  @Nonnull
  Short amount;
  @Nonnull
  RecipeReturnDTO recipe;
  @Nonnull
  String user_uuid;

  public LogReturnDTO(LogEntity entity) {
    this.uuid = entity.getUuid();
    this.date = entity.getDate();
    this.amount = entity.getAmount();
    this.recipe = new RecipeReturnDTO(entity.getRecipe());
    this.user_uuid = "1";
  }

}
