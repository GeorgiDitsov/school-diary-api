package com.ditsov.school_diary.model.common;

import java.time.LocalDate;
import javax.validation.constraints.NotNull;

public class PeriodBean {

  @NotNull private LocalDate startDate;

  @NotNull private LocalDate endDate;

  public PeriodBean() {}

  public LocalDate getStartDate() {
    return startDate;
  }

  public void setStartDate(LocalDate startDate) {
    this.startDate = startDate;
  }

  public LocalDate getEndDate() {
    return endDate;
  }

  public void setEndDate(LocalDate endDate) {
    this.endDate = endDate;
  }
}
