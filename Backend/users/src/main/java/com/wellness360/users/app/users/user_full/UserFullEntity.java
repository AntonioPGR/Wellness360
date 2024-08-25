package com.wellness360.users.app.users.user_full;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Objects;

import org.springframework.data.annotation.CreatedDate;

import com.wellness360.users.app.users.user_basic.UserBasicEntity;
import com.wellness360.users.app.users.user_full.dtos.UserFullCreateDTO;
import com.wellness360.users.app.users.user_full.dtos.UserFullUpdateDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users_full")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserFullEntity {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  protected Integer id;

  private String description;
  private Date birth;
  private String backdrop_url;
  private char gender;
  private int height;
  private String full_name;
  private String work_as;

  @CreatedDate
  private Date created_at;

  // user_id
  @OneToOne
  @MapsId
  @JoinColumn(name = "user_id")
  private UserBasicEntity user;

  public UserFullEntity(UserFullCreateDTO dto) {
    description = dto.description();
    birth = dto.birth();
    backdrop_url = dto.backdrop_url();
    gender = dto.gender();
    height = dto.height();
    full_name = dto.full_name();
    work_as = dto.work_as();
    user = dto.user();
    created_at = Date.valueOf(LocalDate.now());
  }

  public void update(UserFullUpdateDTO dto) {
    description = Objects.requireNonNullElse(dto.description(), description);
    birth = Objects.requireNonNullElse(dto.birth(), birth);
    backdrop_url = Objects.requireNonNullElse(dto.backdrop_url(), backdrop_url);
    int gend = dto.gender();
    gender = Objects.isNull(dto.gender()) || gend == 0? gender : dto.gender();
    height = dto.height() != 0? dto.height() : height;
    full_name = Objects.requireNonNullElse(dto.full_name(), full_name);
    work_as = Objects.requireNonNullElse(dto.work_as(), work_as);
  }

}
