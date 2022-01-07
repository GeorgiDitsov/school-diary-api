package com.ditsov.school_diary.model.school.course;

import com.ditsov.school_diary.model.common.LabeledValueBean;

public abstract class SchoolCourseBean {

  private LabeledValueBean<Long> subject;
  private LabeledValueBean<Long> teacher;
  private LabeledValueBean<Long> group;
  private LabeledValueBean<Long> semester;

  public LabeledValueBean<Long> getSubject() {
    return subject;
  }

  public void setSubject(LabeledValueBean<Long> subject) {
    this.subject = subject;
  }

  public LabeledValueBean<Long> getTeacher() {
    return teacher;
  }

  public void setTeacher(LabeledValueBean<Long> teacher) {
    this.teacher = teacher;
  }

  public LabeledValueBean<Long> getGroup() {
    return group;
  }

  public void setGroup(LabeledValueBean<Long> group) {
    this.group = group;
  }

  public LabeledValueBean<Long> getSemester() {
    return semester;
  }

  public void setSemester(LabeledValueBean<Long> semester) {
    this.semester = semester;
  }
}
