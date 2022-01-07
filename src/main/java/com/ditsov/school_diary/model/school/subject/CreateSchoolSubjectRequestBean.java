package com.ditsov.school_diary.model.school.subject;

import javax.validation.constraints.NotNull;
import com.ditsov.school_diary.core.validator.constraint.Pattern;
import com.ditsov.school_diary.core.validator.constraint.Pattern.Regexp;

public class CreateSchoolSubjectRequestBean {

  @NotNull
  @Pattern(regexp = Regexp.SCHOOL_SUBJECT_NAME, message = "Invalid school subject name")
  private String name;

  public CreateSchoolSubjectRequestBean() {}

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
