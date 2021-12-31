package com.ditsov.school_diary.model.common;

public class LabeledValueBean {

  private String label;
  private Long value;

  public LabeledValueBean() {}

  public String getLabel() {
    return label;
  }

  public void setLabel(String label) {
    this.label = label;
  }

  public Long getValue() {
    return value;
  }

  public void setValue(Long value) {
    this.value = value;
  }
}
