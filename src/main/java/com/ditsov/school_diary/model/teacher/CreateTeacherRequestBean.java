package com.ditsov.school_diary.model.teacher;

import java.util.Set;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import com.ditsov.school_diary.model.common.LabeledValueBean;
import com.ditsov.school_diary.model.person.CreatePersonRequestBean;

public class CreateTeacherRequestBean extends CreatePersonRequestBean {

  @NotNull
  @Size(min = 1)
  private Set<LabeledValueBean<Long>> subjects;

  public CreateTeacherRequestBean() {}

  public Set<LabeledValueBean<Long>> getSubjects() {
    return subjects;
  }

  public void setSubjects(Set<LabeledValueBean<Long>> subjects) {
    this.subjects = subjects;
  }
}
