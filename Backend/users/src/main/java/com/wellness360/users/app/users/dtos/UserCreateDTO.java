package com.wellness360.users.app.users.dtos;

import java.sql.Date;

import org.springframework.web.multipart.MultipartFile;

import com.wellness360.users.packages.crud.dtos.CrudCreateRequestDTO;
import com.wellness360.users.validation.Validator;

public record UserCreateDTO(
  String username,
  String email,
  String password,
  String description,
  Date birth,
  char gender,
  int height,
  String full_name,
  String work_as,
  MultipartFile avatar,
  MultipartFile backdrop
) implements CrudCreateRequestDTO{

  public void validate(Validator validator) {
    validator.string.validateUsername(username);
    validator.string.validateName(full_name);
    validator.validateEmail(email);
    validator.validatePassword(password);
    validator.string.validateText(description);
    validator.validateBirthDate(birth);
    validator.validateGender(gender);
    validator.validateHeight(height);
    validator.string.validateName(work_as);
    validator.media.validateImage(avatar);
    validator.media.validateImage(backdrop);
  }

}
