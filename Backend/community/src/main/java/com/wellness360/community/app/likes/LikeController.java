package com.wellness360.community.app.likes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wellness360.community.app.likes.dtos.LikeCreateDTO;
import com.wellness360.community.app.likes.dtos.LikeReturnDTO;

@RestController
@RequestMapping("${path.like}")
public class LikeController {
  
  @Autowired
  LikeService service;

  @PostMapping
  public ResponseEntity<LikeReturnDTO> create(@RequestBody LikeCreateDTO dto){
    return ResponseEntity.created(null).body(service.create(dto));
  }

  @DeleteMapping("/{post}/{user}")
  public ResponseEntity<LikeReturnDTO> delete(@PathVariable("post") String post_uuid, @PathVariable("user") String user_uuid){
    service.deleteByUserAndPost(post_uuid, user_uuid);
    return ResponseEntity.noContent().build();
  }

}
