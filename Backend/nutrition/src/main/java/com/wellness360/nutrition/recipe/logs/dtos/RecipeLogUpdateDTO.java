package com.wellness360.nutrition.recipe.logs.dtos;

import java.time.LocalDate;
import lombok.*;

@Getter
public class RecipeLogUpdateDTO{
  private String uuid;
  private Long user_id;
  private LocalDate date;
  private Short amount;
}

