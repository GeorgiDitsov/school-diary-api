package com.ditsov.school_diary.model.user;

import javax.validation.constraints.NotNull;
import com.ditsov.school_diary.core.validator.constraint.Pattern;
import com.ditsov.school_diary.core.validator.constraint.Pattern.Regexp;

public class CreateUserRequestBean {

  @NotNull
  @Pattern(regexp = Regexp.USERNAME, message = "Invalid username")
  private String username;

  @NotNull
  @Pattern(regexp = Regexp.PASSWORD, message = "Invalid password")
  private String password;

  @NotNull
  @Pattern(regexp = Regexp.EMAIL, message = "Invalid email")
  private String email;

  public CreateUserRequestBean() {}

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }
}
