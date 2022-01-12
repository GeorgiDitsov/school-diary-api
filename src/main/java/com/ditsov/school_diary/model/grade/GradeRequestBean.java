package com.ditsov.school_diary.model.grade;

import java.math.BigDecimal;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import org.springframework.lang.NonNull;

public class GradeRequestBean {

  @NonNull
  @Min(2)
  @Max(6)
  private BigDecimal value;

  public GradeRequestBean() {}

  public BigDecimal getValue() {
    return value;
  }

  public void setValue(BigDecimal value) {
    this.value = value;
  }
}
