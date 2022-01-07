package com.ditsov.school_diary.model.person;

import com.ditsov.school_diary.core.validator.constraint.Pattern;
import com.ditsov.school_diary.core.validator.constraint.Pattern.Regexp;

public class UpdatePersonRequestBean {

  @Pattern(regexp = Regexp.NAME, message = "Invalid first name", nullable = true)
  private String firstName;

  @Pattern(regexp = Regexp.NAME, message = "Invalid last name", nullable = true)
  private String lastName;

  @Pattern(regexp = Regexp.PIN, message = "Invalid PIN", nullable = true)
  private String pin;

  public UpdatePersonRequestBean() {}

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getPin() {
    return pin;
  }

  public void setPin(String pin) {
    this.pin = pin;
  }
}
