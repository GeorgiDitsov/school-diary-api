package com.ditsov.school_diary.model.school.subject;

import com.ditsov.school_diary.core.validator.constraint.Pattern;
import com.ditsov.school_diary.core.validator.constraint.Pattern.Regexp;

public class UpdateSchoolSubjectRequestBean {

  @Pattern(
      regexp = Regexp.SCHOOL_SUBJECT_NAME,
      message = "Invalid school subject name",
      nullable = true)
  private String name;

  public UpdateSchoolSubjectRequestBean() {}

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
