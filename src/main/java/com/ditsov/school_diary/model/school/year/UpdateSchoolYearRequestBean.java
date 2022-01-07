package com.ditsov.school_diary.model.school.year;

import javax.validation.Valid;
import org.springframework.lang.Nullable;
import com.ditsov.school_diary.core.validator.constraint.Period;
import com.ditsov.school_diary.model.common.PeriodBean;

public class UpdateSchoolYearRequestBean {

  @Nullable private String name;

  @Nullable
  @Valid
  @Period(nullable = true)
  private PeriodBean period;

  public UpdateSchoolYearRequestBean() {}

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
