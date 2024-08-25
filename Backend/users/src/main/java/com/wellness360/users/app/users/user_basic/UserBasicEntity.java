package com.wellness360.users.app.users.user_basic;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.wellness360.users.app.settings.SettingsEntity;
import com.wellness360.users.app.users.user_basic.dtos.UserBasicCreateDTO;
import com.wellness360.users.app.users.user_basic.dtos.UserBasicUpdateDTO;
import com.wellness360.users.app.users.user_full.UserFullEntity;
import com.wellness360.users.packages.crud.entities.UniqueIdentifierEntity;
import com.wellness360.users.packages.crud.entities.interfaces.ICrudEntity;
import com.wellness360.users.settings.enums.UserRoles;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users_basic")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserBasicEntity extends UniqueIdentifierEntity implements UserDetails, ICrudEntity<UserBasicUpdateDTO>{
  
  private String username;
  private String avatar_url;
  private String email;
  private String password;
  private String role;
  private int active = 1;

  // full_id
  @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
  private UserFullEntity full_info;

  // settings_id
  @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
  private SettingsEntity settings;

  public UserBasicEntity(UserBasicCreateDTO dto){
    username = dto.username();
    avatar_url = dto.avatar_url();
    email = dto.email();
    password = dto.password();
    role = UserRoles.USER.getRole();
  }

  public void update(UserBasicUpdateDTO dto) {
    username = Objects.requireNonNullElse(dto.username(), username);
    avatar_url = Objects.requireNonNullElse(dto.avatar_url(), avatar_url);
    email = Objects.requireNonNullElse(dto.email(), email);
    password = Objects.requireNonNullElse(dto.password(), password);
  }

  public void deactivate(){
    active = 0;
  }

  @PrePersist
  @PreUpdate
  public void encryptPassword(){
    setPassword(new BCryptPasswordEncoder().encode(getPassword()));
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    if(this.role.equals("ADMIN")) return List.of(new SimpleGrantedAuthority("ROLE_"+UserRoles.ADMIN), new SimpleGrantedAuthority("ROLE_"+UserRoles.USER));
    else return List.of(new SimpleGrantedAuthority("ROLE_"+UserRoles.USER));
  }

}
