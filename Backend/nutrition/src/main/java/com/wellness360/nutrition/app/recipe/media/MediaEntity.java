package com.wellness360.nutrition.app.recipe.media;

import java.util.Objects;

import com.wellness360.nutrition.app.recipe.RecipeEntity;
import com.wellness360.nutrition.app.recipe.media.dtos.MediaUpdatePersistenceDTO;
import com.wellness360.nutrition.packages.crud.entities.UniqueIdentifierEntity;
import com.wellness360.nutrition.packages.crud.entities.interfaces.CrudEntity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "recipes_media")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MediaEntity extends UniqueIdentifierEntity implements CrudEntity<MediaUpdatePersistenceDTO>{

  @Column(name = "media_url", nullable = false, length = 150)
  String media_url;
  
  // RELATIONSHIPS
  @ManyToOne
  @JoinColumn(name = "recipe_id" )
  RecipeEntity recipe;

  public void update(MediaUpdatePersistenceDTO url_dto) {
    media_url = Objects.requireNonNullElse(url_dto.media_url(), media_url);
    recipe = Objects.requireNonNullElse(url_dto.recipe(), recipe);
  }

}

