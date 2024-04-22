package com.wellness360.nutrition.entities;

import java.time.LocalDate;
import com.wellness360.nutrition.entities.base.IdNUuidBasedEntity;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name = "recipes_log")
public class RecipeLogEntity extends IdNUuidBasedEntity {

  // ATTRIBUTES
  @Column(name = "user_id", nullable = false)
  private Long userId;

  @Column(name = "date", nullable = false)
  private LocalDate date;

  // RELATIONSHIPS
  @ManyToOne
  @JoinColumn(name = "recipe_id", referencedColumnName = "id", insertable = false, updatable = false)
  private RecipeEntity recipe;

}

