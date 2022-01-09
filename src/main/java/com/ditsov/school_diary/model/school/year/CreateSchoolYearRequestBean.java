package com.ditsov.school_diary.model.school.year;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import com.ditsov.school_diary.core.validator.constraint.Period;
import com.ditsov.school_diary.model.common.PeriodBean;
import com.ditsov.school_diary.model.common.PeriodableBean;

public class CreateSchoolYearRequestBean extends PeriodableBean {

  @NotNull private String name;

  public CreateSchoolYearRequestBean() {}

  @NotNull
  @Valid
  @Period
  @Override
  public PeriodBean getPeriod() {
    return super.getPeriod();
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
