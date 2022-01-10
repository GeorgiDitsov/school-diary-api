package com.ditsov.school_diary.model.grade;

public class GradeStatistics {

  private Long studentId;
  private Long schoolCourseId;
  private Double average;

  public GradeStatistics() {}

  public GradeStatistics(Long studentId, Long schoolCourseId, Double average) {
    this.studentId = studentId;
    this.schoolCourseId = schoolCourseId;
    this.average = average;
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

  public Double getAverage() {
    return average;
  }

  public void setAverage(Double average) {
    this.average = average;
  }
}
