package com.ditsov.school_diary.model.child;

import java.math.BigDecimal;

public class ChildResponseBean {

  private Long id;
  private String fullName;
  private String pin;
  private String group;
  private BigDecimal success;

  public ChildResponseBean() {}

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getFullName() {
    return fullName;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  public String getPin() {
    return pin;
  }

  public void setPin(String pin) {
    this.pin = pin;
  }

  public String getGroup() {
    return group;
  }

  public void setGroup(String group) {
    this.group = group;
  }

  public BigDecimal getSuccess() {
    return success;
  }

  public void setSuccess(BigDecimal success) {
    this.success = success;
  }
}
