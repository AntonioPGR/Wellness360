package com.wellness360.nutrition.app.recipe.dtos;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.wellness360.nutrition.app.recipe.ingredient.dto.IngredientCreateRequestDTO;
import com.wellness360.nutrition.app.recipe.section.dtos.SectionCreateRequestDTO;
import com.wellness360.nutrition.packages.crud.dtos.CrudCreateRequestDTO;
import com.wellness360.nutrition.validation.Validator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecipeCreateRequestDTO implements CrudCreateRequestDTO {
    
    private String name;
    private String description;
    private String category_uuid;
    private List<MultipartFile> media;
    private List<IngredientCreateRequestDTO> ingredients;
    private List<SectionCreateRequestDTO> sections;

    public void validate(Validator validator) {
      validator.string.validateName(name);
      validator.string.validateText(description, true);
      validator.string.validateUuid(category_uuid);
      media.forEach(image -> validator.media.validateImage(image));
      ingredients.forEach(ingredient -> ingredient.validate(validator));
      sections.forEach(section -> section.validate(validator));
    }
}
