package com.wellness360.community.app.posts;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wellness360.community.app.posts.dto.PostCreateRequestDTO;
import com.wellness360.community.app.posts.dto.PostReturnDTO;
import com.wellness360.community.app.posts.dto.PostUpdateRequestDTO;
import com.wellness360.community.packages.crud.controllers.CrudController;

@RestController
@RequestMapping("${path.post}")
public class PostController extends CrudController<
  PostCreateRequestDTO,
  PostUpdateRequestDTO,
  PostReturnDTO,
  PostService
>{  
  
}
