package com.ditsov.school_diary.model.user;

import com.ditsov.school_diary.core.validator.constraint.NullableOrPattern;
import com.ditsov.school_diary.util.Regexp;

public class UpdateUserRequestBean {

  @NullableOrPattern(regexp = Regexp.USERNAME_REGEX, message = "Invalid username")
  private String username;

  @NullableOrPattern(regexp = Regexp.PASSWORD_REGEX, message = "Invalid password")
  private String password;

  @NullableOrPattern(regexp = Regexp.EMAIL_REGEX, message = "Invalid email")
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
