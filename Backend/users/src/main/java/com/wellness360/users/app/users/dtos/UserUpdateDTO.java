package com.wellness360.users.app.users.dtos;

import java.sql.Date;

import org.springframework.web.multipart.MultipartFile;

import com.wellness360.users.validation.Validator;

public record UserUpdateDTO(
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
){

  public void validate(Validator validator) {
    validator.string.validateUsername(username, true);
    validator.string.validateName(full_name, true);
    validator.validateEmail(email, true);
    validator.validatePassword(password, true);
    validator.string.validateText(description, true);
    validator.validateBirthDate(birth, true);
    validator.validateGender(gender, true);
    validator.validateHeight(height, true);
    validator.string.validateName(work_as, true);
    validator.media.validateImage(avatar, true);
    validator.media.validateImage(backdrop, true);
  }

}
