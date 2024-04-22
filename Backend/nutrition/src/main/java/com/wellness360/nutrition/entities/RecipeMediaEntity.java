package com.wellness360.nutrition.entities;

import com.wellness360.nutrition.entities.base.IdNUuidBasedEntity;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter(value = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name = "recipes_media")
public class RecipeMediaEntity extends IdNUuidBasedEntity {

  // ATTRIBUTES
  @Column(name = "media_url", nullable = false, length = 150)
  private String media_url;
  
  @Column(name = "media_type", nullable = false, length = 20)
  private String media_type;
  
  // RELATIONSHIPS
  @ManyToOne
  @JoinColumn(name = "recipe_id", referencedColumnName = "id", insertable = false, updatable = false)
  private RecipeEntity recipe;
  

}

