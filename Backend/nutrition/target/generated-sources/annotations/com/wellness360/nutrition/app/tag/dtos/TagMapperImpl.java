package com.wellness360.nutrition.app.tag.dtos;

import com.wellness360.nutrition.app.category.CategoryEntity;
import com.wellness360.nutrition.app.category.dtos.CategoryReturnDTO;
import com.wellness360.nutrition.app.tag.TagEntity;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-19T01:02:09-0300",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.39.0.v20240820-0604, environment: Java 17.0.12 (Eclipse Adoptium)"
)
public class TagMapperImpl implements TagMapper {

    @Override
    public TagReturnCompleteDTO entityToReturn(TagEntity entity) {
        if ( entity == null ) {
            return null;
        }

        String uuid = null;
        String name = null;
        String description = null;
        String image_url = null;
        CategoryReturnDTO category = null;

        uuid = entity.getUuid();
        name = entity.getName();
        description = entity.getDescription();
        image_url = entity.getImage_url();
        category = categoryEntityToCategoryReturnDTO( entity.getCategory() );

        TagReturnCompleteDTO tagReturnCompleteDTO = new TagReturnCompleteDTO( uuid, name, description, image_url, category );

        return tagReturnCompleteDTO;
    }

    @Override
    public TagReturnSimplifiedDTO entityToReturnSimplified(TagEntity entity) {
        if ( entity == null ) {
            return null;
        }

        String uuid = null;
        String name = null;
        String description = null;
        String image_url = null;

        uuid = entity.getUuid();
        name = entity.getName();
        description = entity.getDescription();
        image_url = entity.getImage_url();

        TagReturnSimplifiedDTO tagReturnSimplifiedDTO = new TagReturnSimplifiedDTO( uuid, name, description, image_url );

        return tagReturnSimplifiedDTO;
    }

    @Override
    public TagCreatePersistenceDTO createRequestToPersistence(TagCreateRequestDTO dto, String image_url, CategoryEntity category) {
        if ( dto == null && image_url == null && category == null ) {
            return null;
        }

        String name = null;
        String description = null;
        if ( dto != null ) {
            name = dto.name();
            description = dto.description();
        }
        String image_url1 = null;
        image_url1 = image_url;
        CategoryEntity category1 = null;
        category1 = category;

        TagCreatePersistenceDTO tagCreatePersistenceDTO = new TagCreatePersistenceDTO( name, description, image_url1, category1 );

        return tagCreatePersistenceDTO;
    }

    @Override
    public TagUpdatePersistenceDTO updateRequestToPersistence(TagUpdateRequestDTO dto, String image_url, CategoryEntity category) {
        if ( dto == null && image_url == null && category == null ) {
            return null;
        }

        String uuid = null;
        String name = null;
        String description = null;
        if ( dto != null ) {
            uuid = dto.uuid();
            name = dto.name();
            description = dto.description();
        }
        String image_url1 = null;
        image_url1 = image_url;
        CategoryEntity category1 = null;
        category1 = category;

        TagUpdatePersistenceDTO tagUpdatePersistenceDTO = new TagUpdatePersistenceDTO( uuid, name, description, image_url1, category1 );

        return tagUpdatePersistenceDTO;
    }

    @Override
    public TagEntity createPersistenceToEntity(TagCreatePersistenceDTO dto) {
        if ( dto == null ) {
            return null;
        }

        TagEntity tagEntity = new TagEntity();

        tagEntity.setCategory( dto.category() );
        tagEntity.setDescription( dto.description() );
        tagEntity.setImage_url( dto.image_url() );
        tagEntity.setName( dto.name() );

        return tagEntity;
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
}
