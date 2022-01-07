package com.ditsov.school_diary.model.school.course;

import org.springframework.lang.Nullable;
import com.ditsov.school_diary.core.validator.constraint.SchoolCourse;
import com.ditsov.school_diary.model.common.LabeledValueBean;

@SchoolCourse(nullable = true)
public class UpdateSchoolCourseRequestBean extends SchoolCourseRequestBean {

  public UpdateSchoolCourseRequestBean() {}

  @Nullable
  @Override
  public LabeledValueBean<Long> getSubject() {
    return super.getSubject();
  }

  @Nullable
  @Override
  public LabeledValueBean<Long> getTeacher() {
    return super.getTeacher();
  }

  @Nullable
  @Override
  public LabeledValueBean<Long> getGroup() {
    return super.getGroup();
  }

  @Nullable
  @Override
  public LabeledValueBean<Long> getSemester() {
    return super.getSemester();
  }
}
