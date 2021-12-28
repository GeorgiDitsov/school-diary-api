package com.ditsov.school_diary.model.authentication;

public class AuthenticationResponseBean {

  private String prefix = "Bearer ";
  private String token;

  public AuthenticationResponseBean() {}

  public String getPrefix() {
    return prefix;
  }

  public void setPrefix(String prefix) {
    this.prefix = prefix;
  }

  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }
}
