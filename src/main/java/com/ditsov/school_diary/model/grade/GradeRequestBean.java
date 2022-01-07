package com.ditsov.school_diary.model.grade;

public abstract class GradeRequestBean {

  private Double value;
  private Long studentId;
  private Long schoolCourseId;

  public Double getValue() {
    return value;
  }

  public void setValue(Double value) {
    this.value = value;
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
}
