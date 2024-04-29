package com.wellness360.nutrition.recipe.media;

import java.util.UUID;

import com.wellness360.nutrition.recipe.RecipeEntity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "recipes_media")
@Getter
@Setter(value = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class RecipeMediaEntity{

  // ATTRIBUTES
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  
  @Column(name = "uuid", unique = true, nullable = false, length = 36)
  private String uuid;

  @Column(name = "media_url", nullable = false, length = 150)
  private String media_url;
  
  @Column(name = "media_type", nullable = false, length = 20)
  private String media_type;
  
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

