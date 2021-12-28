package com.ditsov.school_diary.model.common;

public class ErrorResponseBean {

  private String code;
  private String message;

  public ErrorResponseBean() {}

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }
}
