package com.wellness360.nutrition.app.logs.dtos;

import com.wellness360.nutrition.app.logs.LogEntity;
import com.wellness360.nutrition.app.recipe.RecipeEntity;
import com.wellness360.nutrition.app.recipe.dtos.RecipeMapper;
import com.wellness360.nutrition.app.recipe.dtos.RecipeReturnDTO;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-19T00:19:24-0300",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.39.0.v20240820-0604, environment: Java 17.0.12 (Eclipse Adoptium)"
)
public class LogMapperImpl implements LogMapper {

    private final RecipeMapper recipeMapper = RecipeMapper.INSTANCE;

    @Override
    public LogCreatePersistenceDTO createRequestToPersistence(LogCreateRequestDTO dto, RecipeEntity recipe) {
        if ( dto == null && recipe == null ) {
            return null;
        }

        LocalDate date = null;
        Short amount = null;
        String user_uuid = null;
        if ( dto != null ) {
            if ( dto.date() != null ) {
                date = LocalDateTime.ofInstant( dto.date().toInstant(), ZoneOffset.UTC ).toLocalDate();
            }
            amount = dto.amount();
            user_uuid = dto.user_uuid();
        }
        RecipeEntity recipe1 = null;
        recipe1 = recipe;

        LogCreatePersistenceDTO logCreatePersistenceDTO = new LogCreatePersistenceDTO( date, amount, recipe1, user_uuid );

        return logCreatePersistenceDTO;
    }

    @Override
    public LogReturnDTO entityToReturn(LogEntity entity) {
        if ( entity == null ) {
            return null;
        }

        String uuid = null;
        LocalDate date = null;
        Short amount = null;
        RecipeReturnDTO recipe = null;

        uuid = entity.getUuid();
        date = entity.getDate();
        amount = entity.getAmount();
        recipe = recipeMapper.entityToReturn( entity.getRecipe() );

        LogReturnDTO logReturnDTO = new LogReturnDTO( uuid, date, amount, recipe );

        return logReturnDTO;
    }

    @Override
    public LogUpdatePersistenceDTO updateRequestToPersistence(LogUpdateRequestDTO dto, RecipeEntity recipe) {
        if ( dto == null && recipe == null ) {
            return null;
        }

        String uuid = null;
        LocalDate date = null;
        Short amount = null;
        String user_uuid = null;
        if ( dto != null ) {
            uuid = dto.uuid();
            if ( dto.date() != null ) {
                date = LocalDateTime.ofInstant( dto.date().toInstant(), ZoneOffset.UTC ).toLocalDate();
            }
            amount = dto.amount();
            user_uuid = dto.user_uuid();
        }
        RecipeEntity recipe1 = null;
        recipe1 = recipe;

        LogUpdatePersistenceDTO logUpdatePersistenceDTO = new LogUpdatePersistenceDTO( uuid, date, amount, recipe1, user_uuid );

        return logUpdatePersistenceDTO;
    }

    @Override
    public LogEntity createPersistenceToEntity(LogCreatePersistenceDTO dto) {
        if ( dto == null ) {
            return null;
        }

        LogEntity logEntity = new LogEntity();

        logEntity.setAmount( dto.amount() );
        logEntity.setDate( dto.date() );
        logEntity.setRecipe( dto.recipe() );
        logEntity.setUser_uuid( dto.user_uuid() );

        return logEntity;
    }
}
