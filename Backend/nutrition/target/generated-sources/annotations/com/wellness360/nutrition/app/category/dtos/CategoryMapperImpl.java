package com.wellness360.nutrition.app.category.dtos;

import com.wellness360.nutrition.app.category.CategoryEntity;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-19T01:02:09-0300",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.39.0.v20240820-0604, environment: Java 17.0.12 (Eclipse Adoptium)"
)
public class CategoryMapperImpl implements CategoryMapper {

    @Override
    public CategoryCreatePersistenceDTO createRequestToPersistence(CategoryCreateRequestDTO dto, String image_url) {
        if ( dto == null && image_url == null ) {
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

        CategoryCreatePersistenceDTO categoryCreatePersistenceDTO = new CategoryCreatePersistenceDTO( name, description, image_url1 );

        return categoryCreatePersistenceDTO;
    }

    @Override
    public CategoryReturnDTO entityToReturn(CategoryEntity entity) {
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

        CategoryReturnDTO categoryReturnDTO = new CategoryReturnDTO( uuid, name, description, image_url );

        return categoryReturnDTO;
    }

    @Override
    public CategoryUpdatePersistenceDTO updateRequestToPersistence(CategoryUpdateRequestDTO dto, String image_url) {
        if ( dto == null && image_url == null ) {
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

        CategoryUpdatePersistenceDTO categoryUpdatePersistenceDTO = new CategoryUpdatePersistenceDTO( uuid, name, description, image_url1 );

        return categoryUpdatePersistenceDTO;
    }

    @Override
    public CategoryEntity createPersistenceToEntity(CategoryCreatePersistenceDTO dto) {
        if ( dto == null ) {
            return null;
        }

        CategoryEntity categoryEntity = new CategoryEntity();

        categoryEntity.setDescription( dto.description() );
        categoryEntity.setImage_url( dto.image_url() );
        categoryEntity.setName( dto.name() );

        return categoryEntity;
    }
}
