package com.wellness360.exercises.settings;

import com.wellness360.exercises.settings.interfaces.IImageEnum;
import com.wellness360.exercises.settings.interfaces.ISubmuscle;

public enum BodyMusclesEnum implements IImageEnum{
  CHEST(chest_muscles.values()),
  BACK(back_muscles.values()),
  ARMS(arms_muscles.values()),
  LEGS(legs_muscles.values()),
  ABDOMINALS(new ISubmuscle[]{}),
  SHOULDERS(new ISubmuscle[]{});

  public String getPackge() {
    return "muscles";
  }

  final ISubmuscle[] submuscles;
  BodyMusclesEnum(ISubmuscle[] submuscles){
    this.submuscles = submuscles;
  }

  // SUBMUSCLES
  public enum chest_muscles implements ISubmuscle{
    MINOR,
    MAJOR;

    public String getGroupName() {
      return BodyMusclesEnum.CHEST.name();
    }
  }

  public enum back_muscles implements ISubmuscle{
    TRAPEZIUS,
    LATISSIMUS;

    public String getGroupName() {
      return BodyMusclesEnum.BACK.name();
    }
  }

  public enum arms_muscles implements ISubmuscle{
    BICEPS,
    TRICEPS,
    FOREARMS;

    public String getGroupName() {
      return BodyMusclesEnum.ARMS.name();
    }
  }

  public enum legs_muscles implements ISubmuscle{
    CALVES,
    HAMSTRINGS,
    QUADRICEPS,
    GLUTES;

    public String getGroupName() {
      return BodyMusclesEnum.LEGS.name();
    }
  }

}
