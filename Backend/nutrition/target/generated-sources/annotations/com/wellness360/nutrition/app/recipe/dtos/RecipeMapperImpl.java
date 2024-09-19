package com.wellness360.nutrition.app.recipe.dtos;

import com.wellness360.nutrition.app.category.CategoryEntity;
import com.wellness360.nutrition.app.category.dtos.CategoryReturnDTO;
import com.wellness360.nutrition.app.recipe.RecipeEntity;
import com.wellness360.nutrition.app.recipe.ingredient.IngredientEntity;
import com.wellness360.nutrition.app.recipe.ingredient.dto.IngredientMapper;
import com.wellness360.nutrition.app.recipe.ingredient.dto.IngredientReturnDTO;
import com.wellness360.nutrition.app.recipe.media.MediaEntity;
import com.wellness360.nutrition.app.recipe.media.dtos.MediaMappers;
import com.wellness360.nutrition.app.recipe.media.dtos.MediaReturnDTO;
import com.wellness360.nutrition.app.recipe.section.SectionEntity;
import com.wellness360.nutrition.app.recipe.section.dtos.SectionMapper;
import com.wellness360.nutrition.app.recipe.section.dtos.SectionReturnDTO;
import com.wellness360.nutrition.app.tag.TagEntity;
import com.wellness360.nutrition.app.tag.dtos.TagReturnSimplifiedDTO;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-19T01:02:09-0300",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.39.0.v20240820-0604, environment: Java 17.0.12 (Eclipse Adoptium)"
)
public class RecipeMapperImpl implements RecipeMapper {

    private final MediaMappers mediaMappers = MediaMappers.INSTANCE;
    private final IngredientMapper ingredientMapper = IngredientMapper.INSTANCE;
    private final SectionMapper sectionMapper = SectionMapper.INSTANCE;

    @Override
    public RecipeCreatePersistenceDTO createRequestToPersistence(RecipeCreateRequestDTO dto, TagEntity tag, CategoryEntity category) {
        if ( dto == null && tag == null && category == null ) {
            return null;
        }

        String name = null;
        String description = null;
        String user_uuid = null;
        if ( dto != null ) {
            name = dto.name();
            description = dto.description();
            user_uuid = dto.user_uuid();
        }
        TagEntity tag1 = null;
        CategoryEntity category1 = null;
        if ( tag != null ) {
            tag1 = tag;
            category1 = tag.getCategory();
        }

        RecipeCreatePersistenceDTO recipeCreatePersistenceDTO = new RecipeCreatePersistenceDTO( name, description, user_uuid, tag1, category1 );

        return recipeCreatePersistenceDTO;
    }

    @Override
    public RecipeReturnDTO entityToReturn(RecipeEntity entity) {
        if ( entity == null ) {
            return null;
        }

        String uuid = null;
        String name = null;
        String description = null;
        TagReturnSimplifiedDTO tag = null;
        CategoryReturnDTO category = null;
        List<MediaReturnDTO> media = null;
        List<IngredientReturnDTO> ingredients = null;
        List<SectionReturnDTO> sections = null;

        uuid = entity.getUuid();
        name = entity.getName();
        description = entity.getDescription();
        tag = tagEntityToTagReturnSimplifiedDTO( entity.getTag() );
        category = categoryEntityToCategoryReturnDTO( entity.getCategory() );
        media = mediaEntitySetToMediaReturnDTOList( entity.getMedia() );
        ingredients = ingredientEntitySetToIngredientReturnDTOList( entity.getIngredients() );
        sections = sectionEntitySetToSectionReturnDTOList( entity.getSections() );

        RecipeReturnDTO recipeReturnDTO = new RecipeReturnDTO( uuid, name, description, tag, category, media, ingredients, sections );

        return recipeReturnDTO;
    }

    @Override
    public RecipeUpdatePersistenceDTO updateRequestToPersistence(RecipeUpdateRequestDTO dto, TagEntity tag, CategoryEntity category) {
        if ( dto == null && tag == null && category == null ) {
            return null;
        }

        String description = null;
        String uuid = null;
        String name = null;
        String user_uuid = null;
        if ( dto != null ) {
            description = dto.description();
            uuid = dto.uuid();
            name = dto.name();
            user_uuid = dto.user_uuid();
        }
        TagEntity tag1 = null;
        CategoryEntity category1 = null;
        if ( tag != null ) {
            tag1 = tag;
            category1 = tag.getCategory();
        }

        RecipeUpdatePersistenceDTO recipeUpdatePersistenceDTO = new RecipeUpdatePersistenceDTO( uuid, name, description, user_uuid, tag1, category1 );

        return recipeUpdatePersistenceDTO;
    }

    @Override
    public RecipeEntity createPersistenceToEntity(RecipeCreatePersistenceDTO dto) {
        if ( dto == null ) {
            return null;
        }

        RecipeEntity recipeEntity = new RecipeEntity();

        recipeEntity.setCategory( dto.category() );
        recipeEntity.setDescription( dto.description() );
        recipeEntity.setName( dto.name() );
        recipeEntity.setTag( dto.tag() );

        return recipeEntity;
    }

    protected TagReturnSimplifiedDTO tagEntityToTagReturnSimplifiedDTO(TagEntity tagEntity) {
        if ( tagEntity == null ) {
            return null;
        }

        String uuid = null;
        String name = null;
        String description = null;
        String image_url = null;

        uuid = tagEntity.getUuid();
        name = tagEntity.getName();
        description = tagEntity.getDescription();
        image_url = tagEntity.getImage_url();

        TagReturnSimplifiedDTO tagReturnSimplifiedDTO = new TagReturnSimplifiedDTO( uuid, name, description, image_url );

        return tagReturnSimplifiedDTO;
    }

    protected CategoryReturnDTO categoryEntityToCategoryReturnDTO(CategoryEntity categoryEntity) {
        if ( categoryEntity == null ) {
            return null;
        }

        String uuid = null;
        String name = null;
        String description = null;
        String image_url = null;

        uuid = categoryEntity.getUuid();
        name = categoryEntity.getName();
        description = categoryEntity.getDescription();
        image_url = categoryEntity.getImage_url();

        CategoryReturnDTO categoryReturnDTO = new CategoryReturnDTO( uuid, name, description, image_url );

        return categoryReturnDTO;
    }

    protected List<MediaReturnDTO> mediaEntitySetToMediaReturnDTOList(Set<MediaEntity> set) {
        if ( set == null ) {
            return null;
        }

        List<MediaReturnDTO> list = new ArrayList<MediaReturnDTO>( set.size() );
        for ( MediaEntity mediaEntity : set ) {
            list.add( mediaMappers.entityToReturn( mediaEntity ) );
        }

        return list;
    }

    protected List<IngredientReturnDTO> ingredientEntitySetToIngredientReturnDTOList(Set<IngredientEntity> set) {
        if ( set == null ) {
            return null;
        }

        List<IngredientReturnDTO> list = new ArrayList<IngredientReturnDTO>( set.size() );
        for ( IngredientEntity ingredientEntity : set ) {
            list.add( ingredientMapper.entityToReturnDTO( ingredientEntity ) );
        }

        return list;
    }

    protected List<SectionReturnDTO> sectionEntitySetToSectionReturnDTOList(Set<SectionEntity> set) {
        if ( set == null ) {
            return null;
        }

        List<SectionReturnDTO> list = new ArrayList<SectionReturnDTO>( set.size() );
        for ( SectionEntity sectionEntity : set ) {
            list.add( sectionMapper.entityToReturn( sectionEntity ) );
        }

        return list;
    }
}
