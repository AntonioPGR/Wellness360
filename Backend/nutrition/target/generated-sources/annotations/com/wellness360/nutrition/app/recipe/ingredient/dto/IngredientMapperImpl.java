package com.wellness360.nutrition.app.recipe.ingredient.dto;

import com.wellness360.nutrition.app.category.CategoryEntity;
import com.wellness360.nutrition.app.category.dtos.CategoryReturnDTO;
import com.wellness360.nutrition.app.food.FoodEntity;
import com.wellness360.nutrition.app.food.dtos.FoodReturnDTO;
import com.wellness360.nutrition.app.recipe.RecipeEntity;
import com.wellness360.nutrition.app.recipe.ingredient.IngredientEntity;
import com.wellness360.nutrition.app.tag.TagEntity;
import com.wellness360.nutrition.app.tag.dtos.TagReturnSimplifiedDTO;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-19T01:02:09-0300",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.39.0.v20240820-0604, environment: Java 17.0.12 (Eclipse Adoptium)"
)
public class IngredientMapperImpl implements IngredientMapper {

    @Override
    public IngredientCreatePersistenceDTO createRequestToPersistence(IngredientCreateRequestDTO dto, FoodEntity food, RecipeEntity recipe) {
        if ( dto == null && food == null && recipe == null ) {
            return null;
        }

        short amount = 0;
        if ( dto != null ) {
            amount = (short) dto.amount();
        }
        FoodEntity food1 = null;
        food1 = food;
        RecipeEntity recipe1 = null;
        recipe1 = recipe;

        IngredientCreatePersistenceDTO ingredientCreatePersistenceDTO = new IngredientCreatePersistenceDTO( food1, recipe1, amount );

        return ingredientCreatePersistenceDTO;
    }

    @Override
    public IngredientUpdatePersistenceDTO updateRequestToPersistence(IngredientUpdateRequestDTO dto, FoodEntity food, RecipeEntity recipe) {
        if ( dto == null && food == null && recipe == null ) {
            return null;
        }

        String uuid = null;
        Short amount = null;
        if ( dto != null ) {
            uuid = dto.uuid();
            amount = dto.amount();
        }
        FoodEntity food1 = null;
        food1 = food;
        RecipeEntity recipe1 = null;
        recipe1 = recipe;

        IngredientUpdatePersistenceDTO ingredientUpdatePersistenceDTO = new IngredientUpdatePersistenceDTO( uuid, recipe1, food1, amount );

        return ingredientUpdatePersistenceDTO;
    }

    @Override
    public IngredientReturnDTO entityToReturnDTO(IngredientEntity entity) {
        if ( entity == null ) {
            return null;
        }

        String uuid = null;
        FoodReturnDTO food = null;
        Short amount = null;

        uuid = entity.getUuid();
        food = foodEntityToFoodReturnDTO( entity.getFood() );
        amount = entity.getAmount();

        IngredientReturnDTO ingredientReturnDTO = new IngredientReturnDTO( uuid, food, amount );

        return ingredientReturnDTO;
    }

    @Override
    public IngredientEntity createPersistenceToEntity(IngredientCreatePersistenceDTO dto) {
        if ( dto == null ) {
            return null;
        }

        IngredientEntity ingredientEntity = new IngredientEntity();

        ingredientEntity.setAmount( dto.amount() );
        ingredientEntity.setFood( dto.food() );
        ingredientEntity.setRecipe( dto.recipe() );

        return ingredientEntity;
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

    protected FoodReturnDTO foodEntityToFoodReturnDTO(FoodEntity foodEntity) {
        if ( foodEntity == null ) {
            return null;
        }

        String uuid = null;
        String name = null;
        String description = null;
        Float calories = null;
        Float carbs = null;
        Float proteins = null;
        Float fats = null;
        Float saturated_fats = null;
        Float sodium = null;
        Float dietary_fiber = null;
        Short serving_amount = null;
        String image_url = null;
        CategoryReturnDTO category = null;
        TagReturnSimplifiedDTO tag = null;

        uuid = foodEntity.getUuid();
        name = foodEntity.getName();
        description = foodEntity.getDescription();
        calories = foodEntity.getCalories();
        carbs = foodEntity.getCarbs();
        proteins = foodEntity.getProteins();
        fats = foodEntity.getFats();
        saturated_fats = foodEntity.getSaturated_fats();
        sodium = foodEntity.getSodium();
        dietary_fiber = foodEntity.getDietary_fiber();
        serving_amount = foodEntity.getServing_amount();
        image_url = foodEntity.getImage_url();
        category = categoryEntityToCategoryReturnDTO( foodEntity.getCategory() );
        tag = tagEntityToTagReturnSimplifiedDTO( foodEntity.getTag() );

        FoodReturnDTO foodReturnDTO = new FoodReturnDTO( uuid, name, description, calories, carbs, proteins, fats, saturated_fats, sodium, dietary_fiber, serving_amount, image_url, category, tag );

        return foodReturnDTO;
    }
}
