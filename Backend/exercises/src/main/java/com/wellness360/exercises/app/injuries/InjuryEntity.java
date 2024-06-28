package com.wellness360.exercises.app.injuries;

import java.util.Date;
import java.util.Objects;

import com.wellness360.exercises.app.injuries.dtos.InjuryCreatePersistenceDTO;
import com.wellness360.exercises.app.injuries.dtos.InjuryUpdatePersistenceDTO;
import com.wellness360.exercises.packages.crud.entities.UniqueIdentifierEntity;
import com.wellness360.exercises.packages.crud.entities.interfaces.IBaseEntity;

import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "injuries")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class InjuryEntity extends UniqueIdentifierEntity implements IBaseEntity<InjuryUpdatePersistenceDTO>{
  
  @Nonnull
  @Size(max = 25)
  String body_part;

  @Nullable
  String description;

  @Nonnull
  @PastOrPresent
  Date initial_date;
  
  @Nonnull
  @FutureOrPresent
  Date end_date;

  @Nonnull
  String user_uuid;

  public InjuryEntity(InjuryCreatePersistenceDTO dto) {
    body_part = dto.getBody_part().name();
    description = dto.getDescription();
    initial_date = dto.getInitial_date();
    end_date = dto.getEnd_date();
    user_uuid = dto.getUser_uuid();
  }

  public void update(InjuryUpdatePersistenceDTO dto) {
    String passed_body_part = dto.getBody_part() != null? dto.getBody_part().name() : null;
    body_part = Objects.requireNonNullElse(passed_body_part, body_part);

    description = Objects.requireNonNullElse(dto.getDescription(), description);
    
    initial_date = Objects.requireNonNullElse(dto.getInitial_date(), initial_date);
    end_date = Objects.requireNonNullElse(dto.getEnd_date(), end_date);
    user_uuid = Objects.requireNonNullElse(dto.getUser_uuid(), user_uuid);
  }

}
