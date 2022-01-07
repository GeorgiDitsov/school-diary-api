package com.ditsov.school_diary.model.school.year;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import com.ditsov.school_diary.core.validator.constraint.Period;
import com.ditsov.school_diary.model.common.PeriodBean;

public class CreateSchoolYearRequestBean {

  @NotNull private String name;

  @NotNull @Valid @Period private PeriodBean period;

  public CreateSchoolYearRequestBean() {}

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public PeriodBean getPeriod() {
    return period;
  }

  public void setPeriod(PeriodBean period) {
    this.period = period;
  }
}
