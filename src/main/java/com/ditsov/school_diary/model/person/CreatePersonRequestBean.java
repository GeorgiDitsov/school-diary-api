package com.ditsov.school_diary.model.person;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import com.ditsov.school_diary.core.validator.constraint.Pattern;
import com.ditsov.school_diary.core.validator.constraint.Pattern.Regexp;
import com.ditsov.school_diary.model.user.CreateUserRequestBean;

public class CreatePersonRequestBean {

  @NotBlank
  @Pattern(regexp = Regexp.NAME, message = "Invalid first name")
  private String firstName;

  @NotBlank
  @Pattern(regexp = Regexp.NAME, message = "Invalid last name")
  private String lastName;

  @NotBlank
  @Pattern(regexp = Regexp.PIN, message = "Invalid PIN")
  private String pin;

  @NotNull @Valid private CreateUserRequestBean user;

  public CreatePersonRequestBean() {}

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

  public CreateUserRequestBean getUser() {
    return user;
  }

  public void setUser(CreateUserRequestBean user) {
    this.user = user;
  }
}
