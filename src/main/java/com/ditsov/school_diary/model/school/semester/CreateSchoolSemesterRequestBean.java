package com.ditsov.school_diary.model.school.semester;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import com.ditsov.school_diary.core.validator.constraint.Period;
import com.ditsov.school_diary.model.common.LabeledValueBean;
import com.ditsov.school_diary.model.common.PeriodBean;
import com.ditsov.school_diary.model.common.PeriodableBean;

public class CreateSchoolSemesterRequestBean extends PeriodableBean {

  @NotNull private String name;

  @NotNull private LabeledValueBean<Long> schoolYear;

  public CreateSchoolSemesterRequestBean() {}

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

  public LabeledValueBean<Long> getSchoolYear() {
    return schoolYear;
  }

  public void setSchoolYear(LabeledValueBean<Long> schoolYear) {
    this.schoolYear = schoolYear;
  }
}
