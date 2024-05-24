package com.wellness360.nutrition.app.recipe.media;

import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.wellness360.nutrition.app.recipe.RecipeEntity;
import com.wellness360.nutrition.app.recipe.media.dtos.MediaCreatePersistenceDTO;
import com.wellness360.nutrition.app.recipe.media.dtos.MediaReturnDTO;
import com.wellness360.nutrition.app.recipe.media.dtos.MediaUpdateRequestDTO;
import com.wellness360.nutrition.app.recipe.media.dtos.MediaUpdatePersistenceDTO;
import com.wellness360.nutrition.common.services.StorageEntityFileService;
import com.wellness360.nutrition.configurations.StorageFolders;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class MediaService{

  @Autowired
  MediaRepository repository;
  @Autowired
  StorageEntityFileService storage_service;

  StorageFolders folder = StorageFolders.recipe;
  
  public void createAll(List<MultipartFile> dto_list, RecipeEntity recipe){
    IntStream.range(0, dto_list.size()-1)
      .forEach(index -> create(dto_list.get(index), recipe, index));
  }
  public MediaReturnDTO create(MultipartFile file, RecipeEntity recipe, Integer id){
    String media_url = storage_service.create(
      recipe.getName()+"_"+id,
      folder.name(),
      file
    );
    MediaCreatePersistenceDTO create_dto = new MediaCreatePersistenceDTO(media_url, recipe);
    MediaEntity entity = new MediaEntity(create_dto);
    entity = repository.save(entity);
    return new MediaReturnDTO(entity);
  }

  public void updateAll(List<MediaUpdateRequestDTO> dto_list, RecipeEntity recipe, String old_name) {
    IntStream.range(0, dto_list.size())
      .forEach(index -> update(dto_list.get(index), recipe, index, old_name));
  }
  public MediaReturnDTO update(MediaUpdateRequestDTO dto, RecipeEntity recipe, Integer id, String old_name){
    String media_url = storage_service.update(
      recipe.getName()+"_"+id,
      folder.name(),
      dto.getMedia(),
      old_name+"_"+id
    );
    MediaUpdatePersistenceDTO update_dto = new MediaUpdatePersistenceDTO(dto, media_url, recipe);
    Optional<MediaEntity> opt_entity = repository.findByUuid(dto.getUuid());
    if(opt_entity.isEmpty()) return null;
    MediaEntity entity = opt_entity.get();
    entity.update(update_dto);
    return new MediaReturnDTO(entity);
  }

  public void delete(String name, int size) {
    IntStream.range(0, size)
      .forEach(index -> {
        storage_service.delete(name+"_"+index, folder.name());
      });
  }

}
