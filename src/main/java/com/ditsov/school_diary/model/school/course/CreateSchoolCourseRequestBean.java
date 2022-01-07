package com.ditsov.school_diary.model.school.course;

import javax.validation.constraints.NotNull;
import com.ditsov.school_diary.core.validator.constraint.SchoolCourse;
import com.ditsov.school_diary.model.common.LabeledValueBean;

@SchoolCourse
public class CreateSchoolCourseRequestBean extends SchoolCourseRequestBean {

  public CreateSchoolCourseRequestBean() {}

  @NotNull
  @Override
  public LabeledValueBean<Long> getSubject() {
    return super.getSubject();
  }

  @NotNull
  @Override
  public LabeledValueBean<Long> getTeacher() {
    return super.getTeacher();
  }

  @NotNull
  @Override
  public LabeledValueBean<Long> getGroup() {
    return super.getGroup();
  }

  @NotNull
  @Override
  public LabeledValueBean<Long> getSemester() {
    return super.getSemester();
  }
}
