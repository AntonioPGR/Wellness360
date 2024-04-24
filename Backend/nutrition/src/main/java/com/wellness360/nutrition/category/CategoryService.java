package com.wellness360.nutrition.category;

import java.net.URI;
import java.util.Optional;
import org.springframework.data.domain.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import com.wellness360.nutrition.category.dtos.CategoryCreateDTO;
import com.wellness360.nutrition.category.dtos.CategoryReturnDTO;
import com.wellness360.nutrition.category.dtos.CategoryUpdateDTO;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@Service
@Transactional
public class CategoryService {

  @Autowired
  CategoryRepository repository;

  public Optional<CategoryReturnDTO> getByUuid(@Valid String category_uuid) {
    Optional<CategoryEntity> category_opt = repository.findByUuid(category_uuid);
    if(category_opt.isPresent()){
      CategoryReturnDTO return_dto = new CategoryReturnDTO(category_opt.get());
      return Optional.of(return_dto);
    }
    return Optional.empty();
  }

  public Page<CategoryReturnDTO> getAll(Pageable pageable) {
    Page<CategoryEntity> categories = repository.findAll(pageable);
    Page<CategoryReturnDTO> return_dto = categories.map(CategoryReturnDTO::new);
    return return_dto;
  }

  public Optional<URI> create(CategoryCreateDTO create_dto){
    CategoryEntity new_category = new CategoryEntity(create_dto);
    repository.save(new_category);
    try{
      URI return_uri = new URI("https://localhost:8080/categories/"+new_category.getUuid());
      return Optional.of(return_uri);
    } catch(Exception e) {
      return Optional.empty();
    }
  }

  public void update(CategoryUpdateDTO update_dto) {
    Optional<CategoryEntity> category_opt = repository.findByUuid(update_dto.getUuid());
    if(category_opt.isPresent()){
      category_opt.get().update(update_dto);
      repository.save(category_opt.get());
    }
  }
  
  public void delete(String category_uuid) {
    repository.deleteByUuid(category_uuid);
  }

}
