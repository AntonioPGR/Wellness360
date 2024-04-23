package com.wellness360.nutrition.recipe;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "recipes_log")
@Getter
@Setter(value = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class RecipeLogEntity{

  // ATTRIBUTES
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  
  @Column(name = "uuid", unique = true, nullable = false, length = 36)
  private UUID uuid;

  @Column(name = "user_id", nullable = false)
  private Long user_id;

  @Column(name = "date", nullable = false)
  private LocalDate date;

  // RELATIONSHIPS
  @ManyToOne
  @JoinColumn(name = "recipe_id",   insertable = false, updatable = false)
  private RecipeEntity recipe;

  @PrePersist
  private void initializeUUID(){
    if(this.uuid == null){
      this.uuid = UUID.randomUUID();
    }
  }

}

