package com.wellness360.nutrition.app.recipe.media.dtos;

import com.wellness360.nutrition.app.recipe.RecipeEntity;
import com.wellness360.nutrition.app.recipe.media.MediaEntity;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-19T00:19:24-0300",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.39.0.v20240820-0604, environment: Java 17.0.12 (Eclipse Adoptium)"
)
public class MediaMappersImpl implements MediaMappers {

    @Override
    public MediaCreatePersistenceDTO createRequestToPersistence(String media_url, RecipeEntity recipe) {
        if ( media_url == null && recipe == null ) {
            return null;
        }

        String media_url1 = null;
        media_url1 = media_url;
        RecipeEntity recipe1 = null;
        recipe1 = recipe;

        MediaCreatePersistenceDTO mediaCreatePersistenceDTO = new MediaCreatePersistenceDTO( media_url1, recipe1 );

        return mediaCreatePersistenceDTO;
    }

    @Override
    public MediaReturnDTO entityToReturn(MediaEntity entity) {
        if ( entity == null ) {
            return null;
        }

        String uuid = null;
        String media_url = null;

        uuid = entity.getUuid();
        media_url = entity.getMedia_url();

        MediaReturnDTO mediaReturnDTO = new MediaReturnDTO( uuid, media_url );

        return mediaReturnDTO;
    }

    @Override
    public MediaUpdatePersistenceDTO updateRequestToPersistence(MediaUpdateRequestDTO dto, String media_url, RecipeEntity recipe) {
        if ( dto == null && media_url == null && recipe == null ) {
            return null;
        }

        String uuid = null;
        if ( dto != null ) {
            uuid = dto.getUuid();
        }
        String media_url1 = null;
        media_url1 = media_url;
        RecipeEntity recipe1 = null;
        recipe1 = recipe;

        MediaUpdatePersistenceDTO mediaUpdatePersistenceDTO = new MediaUpdatePersistenceDTO( uuid, media_url1, recipe1 );

        return mediaUpdatePersistenceDTO;
    }

    @Override
    public MediaEntity createPersistenceToEntity(MediaCreatePersistenceDTO dto) {
        if ( dto == null ) {
            return null;
        }

        MediaEntity mediaEntity = new MediaEntity();

        mediaEntity.setMedia_url( dto.media_url() );
        mediaEntity.setRecipe( dto.recipe() );

        return mediaEntity;
    }
}
