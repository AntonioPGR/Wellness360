package com.wellness360.nutrition.app.tag;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wellness360.nutrition.app.tag.dtos.TagCreateIdsDTO;
import com.wellness360.nutrition.app.tag.dtos.TagReturnCategoryDTO;
import com.wellness360.nutrition.app.tag.dtos.TagReturnOnlyDTO;
import com.wellness360.nutrition.app.tag.dtos.TagUpdateIdsDTO;
import com.wellness360.nutrition.common.CrudBases.CrudController;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("${path.tag}")
public class TagController extends CrudController<
  TagCreateIdsDTO,
  TagUpdateIdsDTO,
  TagReturnCategoryDTO,
  TagService
>{

  @Autowired
  TagService service;

  // NEW METHODS
  @GetMapping("/category/{category_uuid}")
  public ResponseEntity<Page<TagReturnOnlyDTO>> getByCategory(Pageable pageable, @PathVariable("category_uuid") String category_uuid) {
    Page<TagReturnOnlyDTO> results = this.service.getTagsByCategory(pageable, category_uuid);
    return ResponseEntity.ok().body(results);
  }

  @Override
  public TagReturnCategoryDTO createEntity(TagCreateIdsDTO dto) {
    return service.create(dto);
  }

  @Override
  public Optional<TagReturnCategoryDTO> updateEntity(TagUpdateIdsDTO dto) {
    return service.update(dto);
  }
  

}
