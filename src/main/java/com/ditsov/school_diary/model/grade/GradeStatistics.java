package com.ditsov.school_diary.model.grade;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class GradeStatistics {

  private Long studentId;
  private Long schoolCourseId;
  private BigDecimal average;

  public GradeStatistics() {}

  public GradeStatistics(Long studentId, Long schoolCourseId, Double average) {
    this.studentId = studentId;
    this.schoolCourseId = schoolCourseId;
    this.average = BigDecimal.valueOf(average).setScale(2, RoundingMode.HALF_UP);
  }

  public Long getStudentId() {
    return studentId;
  }

  public void setStudentId(Long studentId) {
    this.studentId = studentId;
  }

  public Long getSchoolCourseId() {
    return schoolCourseId;
  }

  public void setSchoolCourseId(Long schoolCourseId) {
    this.schoolCourseId = schoolCourseId;
  }

  public BigDecimal getAverage() {
    return average;
  }

  public void setAverage(BigDecimal average) {
    this.average = average;
  }
}
