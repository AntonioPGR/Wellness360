package com.wellness360.community.app.likes.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LikeCreateDTO {
  
  String post_uuid;
  String user_uuid;

}
