package com.wellness360.nutrition.recipe.section;

import java.util.UUID;

import com.wellness360.nutrition.recipe.RecipeEntity;

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
  private String uuid;

  @Column(name = "name", unique = true, nullable = false, length = 50)
  protected String name;

  @Column(name = "description", columnDefinition = "TEXT")
  private String description;

  @Column(name = "text", nullable = false)
  private String text;

  // RELATIONSHIPS
  @ManyToOne
  @JoinColumn(name = "recipe_id" )
  private RecipeEntity recipe;

  @ManyToOne
  @JoinColumn(name = "included_recipe" )
  private RecipeEntity included_recipe;

  @PrePersist
  private void initializeUUID(){
    if(this.uuid == null){
      this.uuid = UUID.randomUUID().toString();
    }
  }

}

