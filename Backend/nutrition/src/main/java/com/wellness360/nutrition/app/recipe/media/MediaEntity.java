package com.wellness360.nutrition.app.recipe.media;

import java.util.Objects;

import com.wellness360.nutrition.app.recipe.RecipeEntity;
import com.wellness360.nutrition.app.recipe.media.dtos.MediaCreateUrlDTO;
import com.wellness360.nutrition.app.recipe.media.dtos.MediaUpdateUrlDTO;
import com.wellness360.nutrition.common.entities.UniqueIdentifierEntity;
import com.wellness360.nutrition.common.interfaces.BaseEntity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "recipes_media")
@Getter
@Setter(value = AccessLevel.PROTECTED)
@AllArgsConstructor
@NoArgsConstructor
public class MediaEntity extends UniqueIdentifierEntity implements BaseEntity<MediaUpdateUrlDTO>{

  @Column(name = "media_url", nullable = false, length = 150)
  protected String media_url;
  
  // RELATIONSHIPS
  @ManyToOne
  @JoinColumn(name = "recipe_id" )
  protected RecipeEntity recipe;

  public MediaEntity(MediaCreateUrlDTO dto){
    this.media_url = dto.getMedia_url();
    this.recipe = dto.getRecipe();
  }

  public void update(MediaUpdateUrlDTO url_dto) {
    this.media_url = Objects.requireNonNullElse(url_dto.getMedia_url(), this.media_url);
    this.recipe = Objects.requireNonNullElse(url_dto.getRecipe(), this.recipe);
  }

}

