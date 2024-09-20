package com.wellness360.nutrition.app.recipe.media;

import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.wellness360.nutrition.app.recipe.RecipeEntity;
import com.wellness360.nutrition.app.recipe.media.dtos.MediaCreatePersistenceDTO;
import com.wellness360.nutrition.app.recipe.media.dtos.MediaMappers;
import com.wellness360.nutrition.app.recipe.media.dtos.MediaReturnDTO;
import com.wellness360.nutrition.app.recipe.media.dtos.MediaUpdateRequestDTO;
import com.wellness360.nutrition.packages.storage.StorageService;
import com.wellness360.nutrition.settings.storage.StorageFolders;
import com.wellness360.nutrition.app.recipe.media.dtos.MediaUpdatePersistenceDTO;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class MediaService{

  @Autowired
  MediaRepository repository;
  @Autowired
  StorageService storage_service;

  StorageFolders folder = StorageFolders.recipe;
  
  public void createAll(List<MultipartFile> dto_list, RecipeEntity recipe){
    IntStream.range(0, dto_list.size()-1)
      .forEach(index -> create(dto_list.get(index), recipe, index));
  }
  public MediaReturnDTO create(MultipartFile file, RecipeEntity recipe, Integer id){
    String media_url = storage_service.store(
      file,
      folder.name(),
      recipe.getName()+"_"+id
    );
    MediaCreatePersistenceDTO create_dto = new MediaCreatePersistenceDTO(media_url, recipe);
    MediaEntity entity = MediaMappers.INSTANCE.createPersistenceToEntity(create_dto);
    entity = repository.save(entity);
    return MediaMappers.INSTANCE.entityToReturn(entity);
  }

  public void updateAll(List<MediaUpdateRequestDTO> dto_list, RecipeEntity recipe, String old_name) {
    IntStream.range(0, dto_list.size())
      .forEach(index -> update(dto_list.get(index), recipe, index, old_name));
  }
  public MediaReturnDTO update(MediaUpdateRequestDTO dto, RecipeEntity recipe, Integer id, String old_name){
    String media_url = storage_service.update(
      dto.getMedia(),
      old_name+"_"+id
    );
    MediaUpdatePersistenceDTO update_dto = MediaMappers.INSTANCE.updateRequestToPersistence(dto, media_url, recipe);
    Optional<MediaEntity> opt_entity = repository.findByUuid(dto.getUuid());
    if(opt_entity.isEmpty()) return null;
    MediaEntity entity = opt_entity.get();
    entity.update(update_dto);
    return MediaMappers.INSTANCE.entityToReturn(entity);
  }

  public void delete(String name, int size) {
    IntStream.range(0, size)
      .forEach(index -> {
        storage_service.delete(folder.name()+"/"+name+"_"+index);
      });
  }

}
