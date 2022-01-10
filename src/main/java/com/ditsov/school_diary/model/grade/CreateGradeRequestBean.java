package com.ditsov.school_diary.model.grade;

import javax.validation.constraints.Min;
import org.springframework.lang.NonNull;
import com.ditsov.school_diary.core.validator.constraint.Grade;

@Grade
public class CreateGradeRequestBean extends GradeRequestBean {

  @NonNull
  @Min(1)
  private Long studentId;

  @NonNull
  @Min(1)
  private Long schoolCourseId;

  public CreateGradeRequestBean() {}

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
