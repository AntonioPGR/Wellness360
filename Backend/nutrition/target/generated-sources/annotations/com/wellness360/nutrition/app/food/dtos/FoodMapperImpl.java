package com.wellness360.nutrition.app.food.dtos;

import com.wellness360.nutrition.app.category.CategoryEntity;
import com.wellness360.nutrition.app.category.dtos.CategoryMapper;
import com.wellness360.nutrition.app.category.dtos.CategoryReturnDTO;
import com.wellness360.nutrition.app.food.FoodEntity;
import com.wellness360.nutrition.app.tag.TagEntity;
import com.wellness360.nutrition.app.tag.dtos.TagMapper;
import com.wellness360.nutrition.app.tag.dtos.TagReturnSimplifiedDTO;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-19T00:19:24-0300",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.39.0.v20240820-0604, environment: Java 17.0.12 (Eclipse Adoptium)"
)
public class FoodMapperImpl implements FoodMapper {

    private final CategoryMapper categoryMapper = CategoryMapper.INSTANCE;
    private final TagMapper tagMapper = TagMapper.INSTANCE;

    @Override
    public FoodCreatePersistenceDTO createRequestToPersistence(FoodCreateRequestDTO dto, FoodNutrientsDTO nutrients, String image_url, TagEntity tag, CategoryEntity category) {
        if ( dto == null && nutrients == null && image_url == null && tag == null && category == null ) {
            return null;
        }

        String name = null;
        String description = null;
        if ( dto != null ) {
            name = dto.name();
            description = dto.description();
        }
        TagEntity tag1 = null;
        CategoryEntity category1 = null;
        if ( tag != null ) {
            tag1 = tag;
            category1 = tag.getCategory();
        }
        FoodNutrientsDTO nutrients1 = null;
        nutrients1 = nutrients;
        String image_url1 = null;
        image_url1 = image_url;

        FoodCreatePersistenceDTO foodCreatePersistenceDTO = new FoodCreatePersistenceDTO( name, description, nutrients1, image_url1, tag1, category1 );

        return foodCreatePersistenceDTO;
    }

    @Override
    public FoodReturnDTO entityToReturn(FoodEntity entity) {
        if ( entity == null ) {
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

        uuid = entity.getUuid();
        name = entity.getName();
        description = entity.getDescription();
        calories = entity.getCalories();
        carbs = entity.getCarbs();
        proteins = entity.getProteins();
        fats = entity.getFats();
        saturated_fats = entity.getSaturated_fats();
        sodium = entity.getSodium();
        dietary_fiber = entity.getDietary_fiber();
        serving_amount = entity.getServing_amount();
        image_url = entity.getImage_url();
        category = categoryMapper.entityToReturn( entity.getCategory() );
        tag = tagMapper.entityToReturnSimplified( entity.getTag() );

        FoodReturnDTO foodReturnDTO = new FoodReturnDTO( uuid, name, description, calories, carbs, proteins, fats, saturated_fats, sodium, dietary_fiber, serving_amount, image_url, category, tag );

        return foodReturnDTO;
    }

    @Override
    public FoodUpdatePersistenceDTO updateRequestToPersistence(FoodUpdateRequestDTO dto, FoodNutrientsDTO nutrients, String image_url, TagEntity tag, CategoryEntity category) {
        if ( dto == null && nutrients == null && image_url == null && tag == null && category == null ) {
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
        TagEntity tag1 = null;
        CategoryEntity category1 = null;
        if ( tag != null ) {
            tag1 = tag;
            category1 = tag.getCategory();
        }
        FoodNutrientsDTO nutrients1 = null;
        nutrients1 = nutrients;
        String image_url1 = null;
        image_url1 = image_url;

        FoodUpdatePersistenceDTO foodUpdatePersistenceDTO = new FoodUpdatePersistenceDTO( uuid, name, description, nutrients1, image_url1, tag1, category1 );

        return foodUpdatePersistenceDTO;
    }

    @Override
    public FoodEntity createPersistencetToEntity(FoodCreatePersistenceDTO dto) {
        if ( dto == null ) {
            return null;
        }

        FoodEntity foodEntity = new FoodEntity();

        foodEntity.setCalories( dtoNutrientsCalories( dto ) );
        foodEntity.setCarbs( dtoNutrientsCarbs( dto ) );
        foodEntity.setDietary_fiber( dtoNutrientsDietary_fiber( dto ) );
        foodEntity.setFats( dtoNutrientsFats( dto ) );
        foodEntity.setProteins( dtoNutrientsProteins( dto ) );
        foodEntity.setSaturated_fats( dtoNutrientsSaturated_fats( dto ) );
        foodEntity.setServing_amount( dtoNutrientsServing_amount( dto ) );
        foodEntity.setSodium( dtoNutrientsSodium( dto ) );
        foodEntity.setDescription( dto.description() );
        foodEntity.setImage_url( dto.image_url() );
        foodEntity.setName( dto.name() );
        foodEntity.setCategory( dto.category() );
        foodEntity.setTag( dto.tag() );

        return foodEntity;
    }

    private Float dtoNutrientsCalories(FoodCreatePersistenceDTO foodCreatePersistenceDTO) {
        if ( foodCreatePersistenceDTO == null ) {
            return null;
        }
        FoodNutrientsDTO nutrients = foodCreatePersistenceDTO.nutrients();
        if ( nutrients == null ) {
            return null;
        }
        Float calories = nutrients.getCalories();
        if ( calories == null ) {
            return null;
        }
        return calories;
    }

    private Float dtoNutrientsCarbs(FoodCreatePersistenceDTO foodCreatePersistenceDTO) {
        if ( foodCreatePersistenceDTO == null ) {
            return null;
        }
        FoodNutrientsDTO nutrients = foodCreatePersistenceDTO.nutrients();
        if ( nutrients == null ) {
            return null;
        }
        Float carbs = nutrients.getCarbs();
        if ( carbs == null ) {
            return null;
        }
        return carbs;
    }

    private Float dtoNutrientsDietary_fiber(FoodCreatePersistenceDTO foodCreatePersistenceDTO) {
        if ( foodCreatePersistenceDTO == null ) {
            return null;
        }
        FoodNutrientsDTO nutrients = foodCreatePersistenceDTO.nutrients();
        if ( nutrients == null ) {
            return null;
        }
        Float dietary_fiber = nutrients.getDietary_fiber();
        if ( dietary_fiber == null ) {
            return null;
        }
        return dietary_fiber;
    }

    private Float dtoNutrientsFats(FoodCreatePersistenceDTO foodCreatePersistenceDTO) {
        if ( foodCreatePersistenceDTO == null ) {
            return null;
        }
        FoodNutrientsDTO nutrients = foodCreatePersistenceDTO.nutrients();
        if ( nutrients == null ) {
            return null;
        }
        Float fats = nutrients.getFats();
        if ( fats == null ) {
            return null;
        }
        return fats;
    }

    private Float dtoNutrientsProteins(FoodCreatePersistenceDTO foodCreatePersistenceDTO) {
        if ( foodCreatePersistenceDTO == null ) {
            return null;
        }
        FoodNutrientsDTO nutrients = foodCreatePersistenceDTO.nutrients();
        if ( nutrients == null ) {
            return null;
        }
        Float proteins = nutrients.getProteins();
        if ( proteins == null ) {
            return null;
        }
        return proteins;
    }

    private Float dtoNutrientsSaturated_fats(FoodCreatePersistenceDTO foodCreatePersistenceDTO) {
        if ( foodCreatePersistenceDTO == null ) {
            return null;
        }
        FoodNutrientsDTO nutrients = foodCreatePersistenceDTO.nutrients();
        if ( nutrients == null ) {
            return null;
        }
        Float saturated_fats = nutrients.getSaturated_fats();
        if ( saturated_fats == null ) {
            return null;
        }
        return saturated_fats;
    }

    private Short dtoNutrientsServing_amount(FoodCreatePersistenceDTO foodCreatePersistenceDTO) {
        if ( foodCreatePersistenceDTO == null ) {
            return null;
        }
        FoodNutrientsDTO nutrients = foodCreatePersistenceDTO.nutrients();
        if ( nutrients == null ) {
            return null;
        }
        Short serving_amount = nutrients.getServing_amount();
        if ( serving_amount == null ) {
            return null;
        }
        return serving_amount;
    }

    private Float dtoNutrientsSodium(FoodCreatePersistenceDTO foodCreatePersistenceDTO) {
        if ( foodCreatePersistenceDTO == null ) {
            return null;
        }
        FoodNutrientsDTO nutrients = foodCreatePersistenceDTO.nutrients();
        if ( nutrients == null ) {
            return null;
        }
        Float sodium = nutrients.getSodium();
        if ( sodium == null ) {
            return null;
        }
        return sodium;
    }
}
