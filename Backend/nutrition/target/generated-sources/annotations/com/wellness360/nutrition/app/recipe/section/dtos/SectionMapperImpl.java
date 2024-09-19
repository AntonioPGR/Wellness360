package com.wellness360.nutrition.app.recipe.section.dtos;

import com.wellness360.nutrition.app.recipe.RecipeEntity;
import com.wellness360.nutrition.app.recipe.dtos.RecipeMapper;
import com.wellness360.nutrition.app.recipe.dtos.RecipeReturnDTO;
import com.wellness360.nutrition.app.recipe.section.SectionEntity;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-19T01:02:09-0300",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.39.0.v20240820-0604, environment: Java 17.0.12 (Eclipse Adoptium)"
)
public class SectionMapperImpl implements SectionMapper {

    private final RecipeMapper recipeMapper = RecipeMapper.INSTANCE;

    @Override
    public SectionCreatePersistenceDTO createRequestToPersistence(SectionCreateRequestDTO dto, RecipeEntity recipe, RecipeEntity included_recipe) {
        if ( dto == null && recipe == null && included_recipe == null ) {
            return null;
        }

        String text = null;
        if ( dto != null ) {
            text = dto.text();
        }
        RecipeEntity recipe1 = null;
        recipe1 = recipe;
        RecipeEntity included_recipe1 = null;
        included_recipe1 = included_recipe;

        SectionCreatePersistenceDTO sectionCreatePersistenceDTO = new SectionCreatePersistenceDTO( text, included_recipe1, recipe1 );

        return sectionCreatePersistenceDTO;
    }

    @Override
    public SectionReturnDTO entityToReturn(SectionEntity entity) {
        if ( entity == null ) {
            return null;
        }

        RecipeReturnDTO included_recipe_uuid = null;
        String uuid = null;
        String text = null;

        included_recipe_uuid = recipeMapper.entityToReturn( entity.getIncluded_recipe() );
        uuid = entity.getUuid();
        text = entity.getText();

        SectionReturnDTO sectionReturnDTO = new SectionReturnDTO( uuid, text, included_recipe_uuid );

        return sectionReturnDTO;
    }

    @Override
    public SectionUpdatePersistenceDTO updateRequestToPersistence(SectionUpdateRequestDTO dto, RecipeEntity recipe, RecipeEntity included_recipe) {
        if ( dto == null && recipe == null && included_recipe == null ) {
            return null;
        }

        String uuid = null;
        String text = null;
        if ( dto != null ) {
            uuid = dto.uuid();
            text = dto.text();
        }
        RecipeEntity recipe1 = null;
        recipe1 = recipe;
        RecipeEntity included_recipe1 = null;
        included_recipe1 = included_recipe;

        SectionUpdatePersistenceDTO sectionUpdatePersistenceDTO = new SectionUpdatePersistenceDTO( uuid, text, included_recipe1, recipe1 );

        return sectionUpdatePersistenceDTO;
    }

    @Override
    public SectionEntity createPersistenceToEntity(SectionCreatePersistenceDTO dto) {
        if ( dto == null ) {
            return null;
        }

        SectionEntity sectionEntity = new SectionEntity();

        sectionEntity.setIncluded_recipe( dto.included_recipe() );
        sectionEntity.setRecipe( dto.recipe() );
        sectionEntity.setText( dto.text() );

        return sectionEntity;
    }
}
