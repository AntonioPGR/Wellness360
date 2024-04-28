package com.wellness360.nutrition.tag;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.wellness360.common.controllers.FullCrudController;
import com.wellness360.nutrition.tag.dtos.TagCreateIdsDTO;
import com.wellness360.nutrition.tag.dtos.TagReturnCategoryDTO;
import com.wellness360.nutrition.tag.dtos.TagReturnOnlyDTO;
import com.wellness360.nutrition.tag.dtos.TagUpdateIdsDTO;
import java.net.URI;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("${path.tag}")
public class TagController extends FullCrudController<
  TagService,
  TagCreateIdsDTO,
  TagUpdateIdsDTO,
  TagReturnCategoryDTO
>{

  @Autowired
  TagService service;

  protected Optional<URI> createEntity(TagCreateIdsDTO create_dto){
    return service.create(create_dto);
  }

  protected Optional<TagReturnCategoryDTO> updateEntity(TagUpdateIdsDTO dto){
    return service.update(dto);
  }

  // NEW METHODS
  @GetMapping("/category/{category_uuid}")
  public ResponseEntity<Page<TagReturnOnlyDTO>> getByCategory(Pageable pageable, @PathVariable("category_uuid") String category_uuid) {
    Page<TagReturnOnlyDTO> results = this.service.getTagsByCategory(pageable, category_uuid);
    return ResponseEntity.ok().body(results);
  }
  

}
