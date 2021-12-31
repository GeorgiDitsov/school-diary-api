package com.ditsov.school_diary.model.student;

import java.util.List;
import com.ditsov.school_diary.model.common.LabeledValueBean;
import com.ditsov.school_diary.model.person.PersonResponseBean;

public class StudentResponseBean extends PersonResponseBean {

  private LabeledValueBean group;
  private List<LabeledValueBean> parents;

  public StudentResponseBean() {
    super();
  }

  public LabeledValueBean getGroup() {
    return group;
  }

  public void setGroup(LabeledValueBean group) {
    this.group = group;
  }

  public List<LabeledValueBean> getParents() {
    return parents;
  }

  public void setParents(List<LabeledValueBean> parents) {
    this.parents = parents;
  }
}
