package com.wellness360.nutrition.recipe.logs;

import java.time.LocalDate;
import java.util.UUID;

import com.wellness360.nutrition.recipe.RecipeEntity;

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
  private String uuid;

  @Column(name = "user_id", nullable = false)
  private Long user_id;

  @Column(name = "date", nullable = false)
  private LocalDate date;

  @Column(name = "amount", nullable = false)
  private Short amount;

  // RELATIONSHIPS
  @ManyToOne
  @JoinColumn(name = "recipe_id" )
  private RecipeEntity recipe;

  @PrePersist
  private void initializeUUID(){
    if(this.uuid == null){
      this.uuid = UUID.randomUUID().toString();
    }
  }

}

