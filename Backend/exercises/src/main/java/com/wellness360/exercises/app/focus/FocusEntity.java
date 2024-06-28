package com.wellness360.exercises.app.focus;

import java.util.Objects;

import com.wellness360.exercises.app.focus.dtos.FocusCreatePersistenceDTO;
import com.wellness360.exercises.app.focus.dtos.FocusUpdatePersistenceDTO;
import com.wellness360.exercises.packages.crud.entities.UniqueIdentifierEntity;
import com.wellness360.exercises.packages.crud.entities.interfaces.IBaseEntity;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "body_focus")
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class FocusEntity extends UniqueIdentifierEntity implements IBaseEntity<FocusUpdatePersistenceDTO> {
  
  @Column(unique = true)
  @Nonnull
  @Size(max = 25)
  String body_part;

  @Column(unique = true)
  @Nonnull
  @Min(0)
  @Max(5)
  Short priority;

  @Nonnull
  String user_uuid;

  public FocusEntity(FocusCreatePersistenceDTO dto) {
    body_part = dto.getBody_part().name();
    priority = dto.getPriority();
    user_uuid = dto.getUser_uuid();
  }

  public void update(FocusUpdatePersistenceDTO dto) {
    body_part = Objects.requireNonNullElse(dto.getBody_part().name(), body_part);
    priority = Objects.requireNonNullElse(dto.getPriority(), priority);
    user_uuid = Objects.requireNonNullElse(dto.getUser_uuid(), user_uuid);
  }

}
