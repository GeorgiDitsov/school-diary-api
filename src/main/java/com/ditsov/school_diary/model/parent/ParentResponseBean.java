package com.ditsov.school_diary.model.parent;

import java.util.List;
import com.ditsov.school_diary.model.common.LabeledValueBean;
import com.ditsov.school_diary.model.person.PersonResponseBean;

public class ParentResponseBean extends PersonResponseBean {

  private List<LabeledValueBean<Long>> children;

  public ParentResponseBean() {}

  public List<LabeledValueBean<Long>> getChildren() {
    return children;
  }

  public void setChildren(List<LabeledValueBean<Long>> children) {
    this.children = children;
  }
}
