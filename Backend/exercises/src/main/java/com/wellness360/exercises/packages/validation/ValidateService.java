package com.wellness360.exercises.packages.validation;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.wellness360.exercises.enums.BodyMusclesEnum;
import com.wellness360.exercises.enums.CategoriesEnum;

@Service
public class ValidateService {

  @Autowired
  private ValidationUtils utils;
  
  final ValidationProperties properties;
  public ValidateService(ValidationProperties properties){
    this.properties = properties;
  }


  // NAME
  public void validateName(String name){
    this.validateName(name, false);
  }
  public void validateName(String name, Boolean nullable) {
    String label = "Name";
    if(nullable && utils.isNull(name)) return;
    if(utils.isNullOrEmpty(name)) ErrorsThrower.cantBeNull(label);
    if(utils.hasSymbols(name)) ErrorsThrower.validationError(label + " cannot have symbols");
    if(utils.hasNumbers(name)) ErrorsThrower.validationError(label + " cannot have numbers");

    Integer max_lenght = properties.getName_lenght();
    if(utils.isLengthGreaterThan(name, max_lenght)) ErrorsThrower.maxCharactersExceeded(label, max_lenght);
  }


  // TEXT
  public void validateDescription(String text) {
    validateDescription(text, false);
  }
  public void validateDescription(String text, boolean nullable) {
    String label = "Description";
    if(nullable && utils.isNullOrEmpty(text)) return;
    if(utils.isNullOrEmpty(text)) ErrorsThrower.cantBeNull(label);
    Integer max_lenght = properties.getText_lenght();
    if(utils.isLengthGreaterThan(text, max_lenght)) ErrorsThrower.maxCharactersExceeded(label, max_lenght);
  }


  // IMAGE
  public void validateImage(MultipartFile image){
    this.validateImage(image, false);
  }
  public void validateImage(MultipartFile image, Boolean nullable) {
    String label = "Image"; 
    if(nullable && utils.isNull(image)) return;
    if(utils.isNull(image)) ErrorsThrower.cantBeNull(label);
    if(!utils.isMediaExtensionSupported(image, properties.getImage_extensions())) ErrorsThrower.validationError(label + " unsuported type");
    if(utils.isMediaBiggerThanInMb(image, properties.getImage_size())) ErrorsThrower.validationError(label + " size is large than allowed");
  }


  // UUID
  public void validateUuid(String uuid) {
    validateUuid(uuid, false);
  }
  public void validateUuid(String uuid, boolean nullable) {
    String label = "Uuid";
    if(nullable == true && utils.isNull(uuid)) return;
    if(utils.isNullOrEmpty(uuid)) ErrorsThrower.cantBeNull(label);
    if(utils.isLengthDifferentFrom(uuid, 36)) ErrorsThrower.validationError(label + " must have exactly 36 characters");
    if(!utils.isUuidValid(uuid)) ErrorsThrower.validationError(label + " format is invalid");
  }

  // BODY MUSCLE
  public void validateBodyMuscle(String body_muscle) {
    validateBodyMuscle(body_muscle, false);
  }
  public void validateBodyMuscle(String body_muscle, boolean nullable) {
    String label = "Body Muscle";
    if(nullable == true && utils.isNullOrEmpty(body_muscle)) return;
    if(utils.isNullOrEmpty(body_muscle)) ErrorsThrower.cantBeNull(label);
    try{
      BodyMusclesEnum.valueOf(body_muscle.strip().toUpperCase());
    } catch ( Exception e) {
      ErrorsThrower.validationError("Passed " + label + " invalid: could not find any correspondent to " + body_muscle);
    }
  }


  // PRIORITY
  public void validatePriority(Integer priority) {
    validatePriority(priority, false);
  }
  public void validatePriority(Integer priority, boolean nullable) {
    String label = "Priority";
    if(nullable == true && utils.isNull(priority)) return;
    if(utils.isNull(priority)) ErrorsThrower.cantBeNull(label);
    if(priority < 0 || priority > 5) ErrorsThrower.validationError(label + " should be in 0 to 5 range");
  }


  // INITIAL DATE
  public void validateInitialDate(Date initial_date) {
    validateInitialDate(initial_date, false);
  }
  public void validateInitialDate(Date initial_date, boolean nullable) {
    String label = "Initial date";
    if(nullable == true && utils.isNull(initial_date)) return;
    if(utils.isNull(initial_date)) ErrorsThrower.cantBeNull(label);
    if(initial_date.after(new Date())) ErrorsThrower.validationError(label + " can't be in the future");
  }


  // END DATE
  public void validateEndDate(Date end_date, Date initial_date ) {
    validateEndDate(end_date, initial_date, false);
  }
  public void validateEndDate(Date  end_date, Date initial_date, boolean nullable) {
    String label = "End date";
    if(nullable == true && utils.isNull(initial_date)) return;
    if(utils.isNull(initial_date)) ErrorsThrower.cantBeNull(label);
    if(end_date.before(initial_date)) ErrorsThrower.validationError(label + " must have occured after initial date");
  }


  // CATEGORY
  public void validateExerciseCategory(String category) {
    validateExerciseCategory(category, false);
  }
  public void validateExerciseCategory(String category, boolean nullable) {
    String label = "Exercise category";
    if(nullable == true && utils.isNullOrEmpty(category)) return;
    if(utils.isNullOrEmpty(category)) ErrorsThrower.cantBeNull(label);
    try{
      CategoriesEnum.valueOf(category.strip().toUpperCase());
    } catch ( Exception e) {
      ErrorsThrower.validationError("Passed " + label + " invalid: could not find any correspondent to " + category);
    }
  }


  // VIDEO
  public void validateVideo(MultipartFile video) {
    validateVideo(video, false);
  }
  public void validateVideo(MultipartFile video, boolean nullable) {
    String label = "Video"; 
    if(nullable && utils.isNull(video)) return;
    if(utils.isNull(video)) ErrorsThrower.cantBeNull(label);
    if(!utils.isMediaExtensionSupported(video, properties.getVideo_extensions())) ErrorsThrower.validationError(label + " unsuported type");
    if(utils.isMediaBiggerThanInMb(video, properties.getVideo_size())) ErrorsThrower.validationError(label + " size is large than allowed");
  }


  // SHORT
  public void validateShort(Integer number) {
    validateShort(number, false);
  }
  public void validateShort(Integer number, boolean nullable) {
    String label = "Short"; 
    if(nullable && utils.isNull(number)) return;
    if(number >= 32767) ErrorsThrower.validationError(label + "s values can't be more than 32.766");
  }


  // WEEK DAY
  public void validateWeekDay(Integer week_day) {
    validateWeekDay(week_day, false);
  }
  public void validateWeekDay(Integer week_day, boolean nullable) {
    String label = "Week day"; 
    if(nullable && utils.isNull(week_day)) return;
    if(week_day > 7) ErrorsThrower.validationError(label + " must be less or equal 7");
    if(week_day < 1) ErrorsThrower.validationError(label + " must be more or equal 1");
  }


  public void validatePastDate(Date date) {
    validatePresentOrFutureDate(date, false);
  }
  public void validatePresentOrFutureDate(Date date, boolean nullable) {
    String label = "Date";
    if(nullable == true && utils.isNull(date)) return;
    if(utils.isNull(date)) ErrorsThrower.cantBeNull(label);
    if(date.after(new Date())) ErrorsThrower.validationError(label + " can't be in the future");
  }

}
