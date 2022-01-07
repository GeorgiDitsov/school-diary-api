package com.ditsov.school_diary.model.common;

public class LabeledValueBean<V> {

  private String label;
  private V value;

  public LabeledValueBean() {}

  public String getLabel() {
    return label;
  }

  public void setLabel(String label) {
    this.label = label;
  }

  public V getValue() {
    return value;
  }

  public void setValue(V value) {
    this.value = value;
  }
}
