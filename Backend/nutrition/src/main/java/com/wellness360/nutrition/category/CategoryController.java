package com.wellness360.nutrition.category;

import java.net.URI;
import java.util.Optional;
import org.springframework.data.domain.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.annotation.ObjectIdGenerators.None;
import com.wellness360.nutrition.category.dtos.CategoryCreateDTO;
import com.wellness360.nutrition.category.dtos.CategoryReturnDTO;
import com.wellness360.nutrition.category.dtos.CategoryUpdateDTO;
import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/categories")
public class CategoryController {
  
  @Autowired
  private CategoryService category_service;

  @GetMapping
  public ResponseEntity<Page<CategoryReturnDTO>> getCategories(Pageable pageable){
    Page<CategoryReturnDTO> return_dto = category_service.getAll(pageable);
    return ResponseEntity.ok().body(return_dto);
  }

  @GetMapping("/{id}")
  public ResponseEntity<CategoryReturnDTO> getCategory(@PathVariable("id") String category_uuid) {
    Optional<CategoryReturnDTO> return_dto = category_service.getByUuid(category_uuid);
    if(return_dto.isPresent()){
      return ResponseEntity.ok().body(return_dto.get());
    }
    return ResponseEntity.notFound().build();
  }
  
  @PostMapping
  public ResponseEntity<URI> createCategory(@RequestBody CategoryCreateDTO create_dto){
    Optional<URI> item_location = category_service.create(create_dto);
    if(item_location.isPresent()){
      return ResponseEntity.created(item_location.get()).build();
    }
    return ResponseEntity.status(201).build();
  }

  @PutMapping
  public ResponseEntity<None> editCategory(@RequestBody @Valid CategoryUpdateDTO update_dto){
    category_service.update(update_dto);
    return ResponseEntity.noContent().build();
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<None> deleteCategory(@PathVariable("id") String category_uuid){
    category_service.delete(category_uuid);
    return ResponseEntity.noContent().build();
  }

}
