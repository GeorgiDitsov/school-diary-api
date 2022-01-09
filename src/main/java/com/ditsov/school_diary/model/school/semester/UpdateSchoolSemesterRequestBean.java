package com.ditsov.school_diary.model.school.semester;

import javax.validation.Valid;
import org.springframework.lang.Nullable;
import com.ditsov.school_diary.core.validator.constraint.Period;
import com.ditsov.school_diary.model.common.LabeledValueBean;
import com.ditsov.school_diary.model.common.PeriodBean;
import com.ditsov.school_diary.model.common.PeriodableBean;

public class UpdateSchoolSemesterRequestBean extends PeriodableBean {

  @Nullable private String name;

  @Nullable private LabeledValueBean<Long> schoolYear;

  public UpdateSchoolSemesterRequestBean() {}

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

  public LabeledValueBean<Long> getSchoolYear() {
    return schoolYear;
  }

  public void setSchoolYear(LabeledValueBean<Long> schoolYear) {
    this.schoolYear = schoolYear;
  }
}
