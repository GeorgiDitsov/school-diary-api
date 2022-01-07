package com.ditsov.school_diary.model.teacher;

import java.util.Set;
import org.springframework.lang.Nullable;
import com.ditsov.school_diary.model.common.LabeledValueBean;
import com.ditsov.school_diary.model.person.UpdatePersonRequestBean;

public class UpdateTeacherRequestBean extends UpdatePersonRequestBean {

  @Nullable private Set<LabeledValueBean<Long>> subjects;

  public UpdateTeacherRequestBean() {}

  public Set<LabeledValueBean<Long>> getSubjects() {
    return subjects;
  }

  public void setSubjects(Set<LabeledValueBean<Long>> subjects) {
    this.subjects = subjects;
  }
}
