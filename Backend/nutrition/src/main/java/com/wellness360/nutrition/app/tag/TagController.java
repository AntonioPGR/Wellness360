package com.wellness360.nutrition.app.tag;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wellness360.nutrition.app.tag.dtos.TagCreateRequestDTO;
import com.wellness360.nutrition.app.tag.dtos.TagReturnCompleteDTO;
import com.wellness360.nutrition.app.tag.dtos.TagReturnSimplifiedDTO;
import com.wellness360.nutrition.app.tag.dtos.TagUpdateRequestDTO;
import com.wellness360.nutrition.common.crud_bases.CrudImageController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("${path.tag}")
public class TagController extends CrudImageController<
  TagCreateRequestDTO,
  TagUpdateRequestDTO,
  TagReturnCompleteDTO,
  TagService
>{

  @Autowired
  TagService service;

  // NEW METHODS
  @GetMapping("/category/{category_uuid}")
  public ResponseEntity<Page<TagReturnSimplifiedDTO>> getByCategory(Pageable pageable, @PathVariable("category_uuid") String category_uuid) {
    Page<TagReturnSimplifiedDTO> results = this.service.getTagsByCategory(pageable, category_uuid);
    return ResponseEntity.ok().body(results);
  }

}
