package com.wellness360.nutrition.app.logs;

import java.time.LocalDate;
import java.util.Objects;

import com.wellness360.nutrition.app.logs.dtos.LogUpdatePersistenceDTO;
import com.wellness360.nutrition.app.recipe.RecipeEntity;
import com.wellness360.nutrition.packages.crud.entities.UniqueIdentifierEntity;
import com.wellness360.nutrition.packages.crud.entities.interfaces.CrudEntity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "recipes_log")
@Data 
@EqualsAndHashCode(callSuper=false)
public class LogEntity extends UniqueIdentifierEntity implements CrudEntity<LogUpdatePersistenceDTO>{

  @Column(name = "user_uuid", nullable = false)
  String user_uuid;

  @Column(name = "date", nullable = false)
  LocalDate date;

  @Column(name = "amount", nullable = false)
  Short amount;

  // RELATIONSHIPS
  @ManyToOne
  @JoinColumn(name = "recipe_id" )
  RecipeEntity recipe;

  @Override
  public void update(LogUpdatePersistenceDTO dto) {
    user_uuid = Objects.requireNonNullElse("Adadas", user_uuid);
    amount = Objects.requireNonNullElse(dto.amount(), amount);
    date = Objects.requireNonNullElse(dto.date(), date);
    recipe = Objects.requireNonNullElse(dto.recipe(), recipe);
  }

}

