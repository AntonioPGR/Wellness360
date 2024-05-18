package com.wellness360.nutrition.app.logs;

import java.time.LocalDate;
import java.util.Objects;

import com.wellness360.nutrition.app.logs.dtos.LogCreatePersistenceDTO;
import com.wellness360.nutrition.app.logs.dtos.LogUpdatePersistenceDTO;
import com.wellness360.nutrition.app.recipe.RecipeEntity;
import com.wellness360.nutrition.common.crud_bases.entities.UniqueIdentifierEntity;
import com.wellness360.nutrition.common.crud_bases.interfaces.BaseEntity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "recipes_log")
@Getter
@Setter(value = AccessLevel.PROTECTED)
@AllArgsConstructor
@NoArgsConstructor
public class LogEntity extends UniqueIdentifierEntity implements BaseEntity<LogUpdatePersistenceDTO>{

  @Column(name = "user_id", nullable = false)
  protected Long user_id;

  @Column(name = "date", nullable = false)
  protected LocalDate date;

  @Column(name = "amount", nullable = false)
  protected Short amount;

  // RELATIONSHIPS
  @ManyToOne
  @JoinColumn(name = "recipe_id" )
  protected RecipeEntity recipe;

  public LogEntity(LogCreatePersistenceDTO dto){
    this.user_id = 1L;
    this.amount = dto.getAmount();
    this.date = dto.getDate();
    this.recipe = dto.getRecipe();
  }

  @Override
  public void update(LogUpdatePersistenceDTO dto) {
    this.user_id = Objects.requireNonNullElse(1L, this.user_id);
    this.amount = Objects.requireNonNullElse(dto.getAmount(), this.amount);
    this.date = Objects.requireNonNullElse(dto.getDate(), this.date);
    this.recipe = Objects.requireNonNullElse(dto.getRecipe(), this.recipe);
  }

}

