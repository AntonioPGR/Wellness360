package com.wellness360.nutrition.tag;

import java.util.Objects;
import java.util.Set;
import java.util.UUID;

import com.wellness360.common.interfaces.CrudEntity;
import com.wellness360.nutrition.category.CategoryEntity;
import com.wellness360.nutrition.food.FoodEntity;
import com.wellness360.nutrition.recipe.RecipeEntity;
import com.wellness360.nutrition.tag.dtos.TagCreateEntitiesDTO;
import com.wellness360.nutrition.tag.dtos.TagUpdateEntitiesDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "tags")
@Getter
@Setter(value = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class TagEntity implements CrudEntity<TagUpdateEntitiesDTO>{

  public TagEntity(TagCreateEntitiesDTO dto) {
    this.name = dto.getName();
    this.description = dto.getDescription();
    this.image_url = dto.getImage_url();
    this.category = dto.getCategory();
  }

  // ATTRIBUTES
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name="id")
  private Integer id;
  
  @Column(name = "uuid", unique = true, nullable = false, length = 36)
  private String uuid;

  @Column(name = "name", nullable = false, length = 50)
  private String name; 

  @Column(name = "description", columnDefinition = "TEXT")
  private String description;

  @Column(name = "image_url", nullable = false, length = 150)
  private String image_url;

  // RELASHIONSHIPS
  @ManyToOne
  @JoinColumn(name = "category_id", nullable=false)
  private CategoryEntity category;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "tag")
  private Set<FoodEntity> foods;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "tag")
  private Set<RecipeEntity> recipes;

  @PrePersist
  private void initializeUUID(){
    if(this.uuid == null){
      this.uuid = UUID.randomUUID().toString();
    }
  }

  @Override
  public void update(TagUpdateEntitiesDTO dto) {
    this.name = Objects.requireNonNullElse(dto.getName(), this.name);
    this.description = Objects.requireNonNullElse(dto.getDescription(), this.description);
    this.image_url = Objects.requireNonNullElse(dto.getImage_url(), this.image_url);
    this.category = Objects.requireNonNullElse(dto.getCategory(), this.category);
  }

}

