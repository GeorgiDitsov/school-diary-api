package com.ditsov.school_diary.model.school.course;

import java.math.BigDecimal;

public class ExtendedSchoolCourseResponseBean extends SchoolCourseResponseBean {

  private BigDecimal success;

  public ExtendedSchoolCourseResponseBean() {}

  public BigDecimal getSuccess() {
    return success;
  }

  public void setSuccess(BigDecimal success) {
    this.success = success;
  }
}
