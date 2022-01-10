package com.ditsov.school_diary.model.grade;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import org.springframework.lang.NonNull;

public class GradeRequestBean {

  @NonNull
  @Min(2)
  @Max(6)
  private Double value;

  public GradeRequestBean() {}

  public Double getValue() {
    return value;
  }

  public void setValue(Double value) {
    this.value = value;
  }
}
