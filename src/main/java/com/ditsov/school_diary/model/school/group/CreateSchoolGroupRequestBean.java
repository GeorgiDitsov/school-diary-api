package com.ditsov.school_diary.model.school.group;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import com.ditsov.school_diary.core.validator.constraint.Pattern;
import com.ditsov.school_diary.core.validator.constraint.Pattern.Regexp;

public class CreateSchoolGroupRequestBean {

  @NotNull
  @Min(1)
  @Max(12)
  private Integer year;

  @NotNull
  @Pattern(regexp = Regexp.SCHOOL_GROUP_INDEX, message = "Invalid index")
  private String index;

  public CreateSchoolGroupRequestBean() {}

  public Integer getYear() {
    return year;
  }

  public void setYear(Integer year) {
    this.year = year;
  }

  public String getIndex() {
    return index;
  }

  public void setIndex(String index) {
    this.index = index;
  }
}
