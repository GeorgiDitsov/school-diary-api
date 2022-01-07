package com.ditsov.school_diary.model.student;

import java.util.Set;
import javax.validation.constraints.Size;
import org.springframework.lang.Nullable;
import com.ditsov.school_diary.model.common.LabeledValueBean;
import com.ditsov.school_diary.model.person.UpdatePersonRequestBean;

public class UpdateStudentRequestBean extends UpdatePersonRequestBean {

  @Nullable private LabeledValueBean<Long> group;

  @Nullable
  @Size(max = 2)
  private Set<LabeledValueBean<Long>> parents;

  public UpdateStudentRequestBean() {}

  public LabeledValueBean<Long> getGroup() {
    return group;
  }

  public void setGroup(LabeledValueBean<Long> group) {
    this.group = group;
  }

  public Set<LabeledValueBean<Long>> getParents() {
    return parents;
  }

  public void setParents(Set<LabeledValueBean<Long>> parents) {
    this.parents = parents;
  }
}
