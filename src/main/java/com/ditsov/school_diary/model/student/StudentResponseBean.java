package com.ditsov.school_diary.model.student;

import java.util.ArrayList;
import java.util.List;
import com.ditsov.school_diary.model.common.LabeledValueBean;
import com.ditsov.school_diary.model.person.PersonResponseBean;

public class StudentResponseBean extends PersonResponseBean {

  private LabeledValueBean<Long> group;
  private List<LabeledValueBean<Long>> parents = new ArrayList<>();

  public StudentResponseBean() {
    super();
  }

  public LabeledValueBean<Long> getGroup() {
    return group;
  }

  public void setGroup(LabeledValueBean<Long> group) {
    this.group = group;
  }

  public List<LabeledValueBean<Long>> getParents() {
    return parents;
  }

  public void setParents(List<LabeledValueBean<Long>> parents) {
    this.parents = parents;
  }
}
