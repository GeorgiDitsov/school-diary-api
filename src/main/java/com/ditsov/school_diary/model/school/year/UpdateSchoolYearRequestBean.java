package com.ditsov.school_diary.model.school.year;

import javax.validation.Valid;
import org.springframework.lang.Nullable;
import com.ditsov.school_diary.core.validator.constraint.Period;
import com.ditsov.school_diary.model.common.PeriodBean;
import com.ditsov.school_diary.model.common.PeriodableBean;

public class UpdateSchoolYearRequestBean extends PeriodableBean {

  @Nullable private String name;

  public UpdateSchoolYearRequestBean() {}

  @Nullable
  @Valid
  @Period(nullable = true)
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
