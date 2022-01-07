package com.ditsov.school_diary.model.school.semester;

import javax.validation.Valid;
import org.springframework.lang.Nullable;
import com.ditsov.school_diary.core.validator.constraint.Period;
import com.ditsov.school_diary.model.common.LabeledValueBean;
import com.ditsov.school_diary.model.common.PeriodBean;

public class UpdateSchoolSemesterRequestBean {

  @Nullable private String name;

  @Nullable
  @Valid
  @Period(nullable = true)
  private PeriodBean period;

  @Nullable private LabeledValueBean<Long> schoolYear;

  public UpdateSchoolSemesterRequestBean() {}

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

  public LabeledValueBean<Long> getSchoolYear() {
    return schoolYear;
  }

  public void setSchoolYear(LabeledValueBean<Long> schoolYear) {
    this.schoolYear = schoolYear;
  }
}
