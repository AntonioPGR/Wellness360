package com.wellness360.nutrition.app.recipe.media;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wellness360.nutrition.app.recipe.RecipeEntity;
import com.wellness360.nutrition.app.recipe.media.dtos.MediaCreateFileDTO;
import com.wellness360.nutrition.app.recipe.media.dtos.MediaCreateUrlDTO;
import com.wellness360.nutrition.app.recipe.media.dtos.MediaReturnDTO;
import com.wellness360.nutrition.app.recipe.media.dtos.MediaUpdateFileDTO;
import com.wellness360.nutrition.app.recipe.media.dtos.MediaUpdateUrlDTO;
import com.wellness360.nutrition.common.CrudBases.CrudService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class MediaService extends CrudService<
  MediaRepository,
  MediaCreateUrlDTO,
  MediaUpdateUrlDTO,
  MediaReturnDTO,
  MediaEntity
>{

  @Autowired
  MediaRepository repository;
  
  public void createAll(List<MediaCreateFileDTO> dto_list, RecipeEntity recipe){
    dto_list.stream().forEach((dto) -> create(dto, recipe));
  }

  public MediaReturnDTO create(MediaCreateFileDTO dto, RecipeEntity recipe){
    MediaCreateUrlDTO create_dto = new MediaCreateUrlDTO(dto, recipe);
    return super.create(create_dto);
  }

  public void updateAll(List<MediaUpdateFileDTO> dto_list, RecipeEntity recipe) {
    dto_list.stream().forEach((dto) -> update(dto, recipe));
  }

  public Optional<MediaReturnDTO> update(MediaUpdateFileDTO dto, RecipeEntity recipe){
    MediaUpdateUrlDTO update_dto = new MediaUpdateUrlDTO(dto, recipe);
    return super.update(update_dto);
  }

  // INHERIT
  @Override
  public MediaReturnDTO entityToReturnDTO(MediaEntity entity) {
    return new MediaReturnDTO(entity);
  }

  @Override
  public MediaEntity createDTOtoEntity(MediaCreateUrlDTO dto) {
    return new MediaEntity(dto);
  }

}
