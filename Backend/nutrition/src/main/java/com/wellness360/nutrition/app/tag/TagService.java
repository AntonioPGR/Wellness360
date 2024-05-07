package com.wellness360.nutrition.app.tag;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.wellness360.nutrition.app.category.CategoryEntity;
import com.wellness360.nutrition.app.tag.dtos.TagCreateEntitiesDTO;
import com.wellness360.nutrition.app.tag.dtos.TagCreateIdsDTO;
import com.wellness360.nutrition.app.tag.dtos.TagReturnCategoryDTO;
import com.wellness360.nutrition.app.tag.dtos.TagReturnOnlyDTO;
import com.wellness360.nutrition.app.tag.dtos.TagUpdateEntitiesDTO;
import com.wellness360.nutrition.app.tag.dtos.TagUpdateIdsDTO;
import com.wellness360.nutrition.common.CrudBases.CrudService;
import com.wellness360.nutrition.tools.EntityRetrieverByUUID;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class TagService extends CrudService<
  TagRepository,
  TagCreateEntitiesDTO,
  TagUpdateEntitiesDTO,
  TagReturnCategoryDTO,
  TagEntity
>{

  @Autowired 
  EntityRetrieverByUUID uuid_getter;

  // INHERIT
  @Override
  public TagReturnCategoryDTO entityToReturnDTO(TagEntity entity) {
    return new TagReturnCategoryDTO(entity);
  }
  @Override
  public TagEntity createDTOtoEntity(TagCreateEntitiesDTO dto) {
    return new TagEntity(dto);
  }

  // ID to ENTITY dtos
  public TagReturnCategoryDTO create(TagCreateIdsDTO id_dto){
    System.out.println(id_dto.getCategory_uuid());
    CategoryEntity category = uuid_getter.getCategoryByUuid(id_dto.getCategory_uuid());
    System.out.println(category);
    TagCreateEntitiesDTO create_dto = new TagCreateEntitiesDTO(id_dto, category);
    return super.create(create_dto);
  }

  public Optional<TagReturnCategoryDTO> update(TagUpdateIdsDTO id_dto){
    CategoryEntity category = uuid_getter.getCategoryByUuid(id_dto.getCategory_uuid());
    TagUpdateEntitiesDTO update_dto = new TagUpdateEntitiesDTO(id_dto, category);
    return super.update(update_dto);
  }

  public Page<TagReturnOnlyDTO> getTagsByCategory(Pageable pageable, String category_uuid) {
    CategoryEntity category = uuid_getter.getCategoryByUuid(category_uuid);
    Page<TagEntity> entities = this.repository.findAllByCategoryUuid(category.getId(), pageable);
    Page<TagReturnOnlyDTO> return_dto = entities.map(TagReturnOnlyDTO::new);
    return return_dto;
  }
  

}
