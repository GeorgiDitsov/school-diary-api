package com.ditsov.school_diary.model.teacher;

import java.util.ArrayList;
import java.util.List;
import com.ditsov.school_diary.model.common.LabeledValueBean;
import com.ditsov.school_diary.model.person.PersonResponseBean;

public class TeacherResponseBean extends PersonResponseBean {

  private List<LabeledValueBean<Long>> subjects = new ArrayList<>();

  public TeacherResponseBean() {}

  public List<LabeledValueBean<Long>> getSubjects() {
    return subjects;
  }

  public void setSubjects(List<LabeledValueBean<Long>> subjects) {
    this.subjects = subjects;
  }
}
