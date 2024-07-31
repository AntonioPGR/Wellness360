package com.wellness360.community.packages.validation;

import java.util.Date;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

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
  public void validateText(String text) {
    validateText(text, false);
  }
  public void validateText(String text, boolean nullable) {
    String label = "Text";
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


  // DATE
  public void validatePresentOrFutureDate(Date date) {
    validatePresentOrFutureDate(date, false);
  }
  public void validatePresentOrFutureDate(Date date, boolean nullable) {
    String label = "Date";
    if(nullable == true && utils.isNull(date)) return;
    if(utils.isNull(date)) ErrorsThrower.cantBeNull(label);
    if(date.after(new Date())) ErrorsThrower.validationError(label + " can't be in the future");
  }


  // BOOLEAN
  public void validateBoolean(int bool){
    validateBoolean(bool, false);
  }
  public void validateBoolean(int bool, boolean nullable){
    String label = "Boolean";
    if(nullable == true && utils.isNull(bool)) return;
    if(utils.isNull(bool)) ErrorsThrower.cantBeNull(label);
    if(bool != 1 && bool != 0 ) ErrorsThrower.validationError(label + " must be 0 or 1");
  }

  // MEDIA
  public void validateMedia(MultipartFile media){
    validateMedia(media, false);
  }
  public void validateMedia(MultipartFile media, boolean nullable){
    String label = "Media";
    if(nullable == true && utils.isNull(media)) return;
    if(utils.isNull(media)) ErrorsThrower.cantBeNull(label);

    Stream<String> video_extensions = Stream.of(properties.getVideo_extensions());
    Stream<String> image_extensions = Stream.of(properties.getImage_extensions());
    String[] media_extensions = Stream.concat(video_extensions, image_extensions).toArray(String[]::new);
    if(!utils.isMediaExtensionSupported(media, media_extensions)) ErrorsThrower.validationError(label + " unsuported type");
  }

}
