package com.wellness360.nutrition.tag;

import java.net.URI;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.wellness360.common.services.FullCrudService;
import com.wellness360.nutrition.category.CategoryEntity;
import com.wellness360.nutrition.category.CategoryRepository;
import com.wellness360.nutrition.tag.dtos.TagCreateEntitiesDTO;
import com.wellness360.nutrition.tag.dtos.TagCreateIdsDTO;
import com.wellness360.nutrition.tag.dtos.TagReturnCategoryDTO;
import com.wellness360.nutrition.tag.dtos.TagReturnOnlyDTO;
import com.wellness360.nutrition.tag.dtos.TagUpdateEntitiesDTO;
import com.wellness360.nutrition.tag.dtos.TagUpdateIdsDTO;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class TagService extends FullCrudService<
  TagRepository,
  TagCreateEntitiesDTO,
  TagUpdateEntitiesDTO,
  TagReturnCategoryDTO,
  TagEntity
>{

  @Autowired
  CategoryRepository category_repository;

  // DEFAULT
  @Override
  protected TagReturnCategoryDTO createReturnDTO(TagEntity entity) {
    return new TagReturnCategoryDTO(entity);
  }

  @Override
  protected TagEntity createEntity(TagCreateEntitiesDTO dto) {
    return new TagEntity(dto);
  }

  @Override
  protected String getDefaultURL() {
    return "http://localhost:8080/tags";
  }

  // NEW
  public Page<TagReturnOnlyDTO> getTagsByCategory(Pageable pageable, String category_uuid) {
    System.out.println(category_uuid);
    Optional<CategoryEntity> category = category_repository.findByUuid(category_uuid);
    Page<TagEntity> entities = this.repository.findAllByCategoryUuid(category.get().getId(), pageable);
    Page<TagReturnOnlyDTO> return_dto = entities.map(TagReturnOnlyDTO::new);
    return return_dto;
  }

  public Optional<URI> create(TagCreateIdsDTO id_dto) throws Exception{
    Optional<CategoryEntity> category = category_repository.findByUuid(id_dto.getCategory_uuid());
    if(category.isPresent()){
      TagCreateEntitiesDTO create_dto = new TagCreateEntitiesDTO(id_dto, category.get());
      return super.create(create_dto);
    }
    throw new Exception("--------------INVALID CATEGORY------------");
  }

  public Optional<TagReturnCategoryDTO> update(TagUpdateIdsDTO id_dto){
    Optional<CategoryEntity> category = category_repository.findByUuid(id_dto.getCategory_uuid());
    TagUpdateEntitiesDTO update_dto;
    if(category.isPresent()){
      update_dto = new TagUpdateEntitiesDTO(id_dto, category.get());
    }
    update_dto = new TagUpdateEntitiesDTO(id_dto, null);
    return super.update(update_dto);
  }

}
