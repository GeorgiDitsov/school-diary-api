package com.ditsov.school_diary.model.authentication;

import java.time.LocalDateTime;

public class AuthenticationResponseBean {

  private String prefix = "Bearer ";
  private String token;
  private LocalDateTime expiresAt;

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

  public LocalDateTime getExpiresAt() {
    return expiresAt;
  }

  public void setExpiresAt(LocalDateTime expiresAt) {
    this.expiresAt = expiresAt;
  }
}
