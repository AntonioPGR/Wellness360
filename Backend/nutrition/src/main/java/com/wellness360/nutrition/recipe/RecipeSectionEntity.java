package com.wellness360.nutrition.recipe;

import java.util.UUID;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "recipes_sections")
@Getter
@Setter(value = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class RecipeSectionEntity{

  // ATTRIBUTES
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  
  @Column(name = "uuid", unique = true, nullable = false, length = 36)
  private UUID uuid;

  @Column(name = "name", unique = true, nullable = false, length = 50)
  protected String name;

  @Column(name = "description", columnDefinition = "TEXT")
  private String description;

  @Column(name = "text", nullable = false)
  private String text;

  // RELATIONSHIPS
  @ManyToOne
  @JoinColumn(name = "recipe_id",   insertable = false, updatable = false)
  private RecipeEntity recipe;

  @ManyToOne
  @JoinColumn(name = "included_recipe",   insertable = false, updatable = false)
  private RecipeEntity included_recipe;

  @PrePersist
  private void initializeUUID(){
    if(this.uuid == null){
      this.uuid = UUID.randomUUID();
    }
  }

}

