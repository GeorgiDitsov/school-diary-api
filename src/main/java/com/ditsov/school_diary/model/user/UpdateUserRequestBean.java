package com.ditsov.school_diary.model.user;

import com.ditsov.school_diary.core.validator.constraint.Pattern;
import com.ditsov.school_diary.core.validator.constraint.Pattern.Regexp;

public class UpdateUserRequestBean {

  @Pattern(regexp = Regexp.USERNAME, message = "Invalid username", nullable = true)
  private String username;

  @Pattern(regexp = Regexp.PASSWORD, message = "Invalid password", nullable = true)
  private String password;

  @Pattern(regexp = Regexp.EMAIL, message = "Invalid email", nullable = true)
  private String email;

  public UpdateUserRequestBean() {}

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
