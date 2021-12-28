package com.ditsov.school_diary.model.authentication;

import javax.validation.constraints.Size;

public class AuthenticationRequestBean {

  @Size(min = 5, max = 25)
  private String username;

  @Size(min = 5, max = 50)
  private String password;

  public AuthenticationRequestBean() {}

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
}
