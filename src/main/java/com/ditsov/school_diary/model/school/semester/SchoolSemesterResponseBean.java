package com.ditsov.school_diary.model.school.semester;

import java.time.LocalDate;
import com.ditsov.school_diary.model.common.LabeledValueBean;

public class SchoolSemesterResponseBean {

  private Long id;
  private String name;
  private LocalDate startDate;
  private LocalDate endDate;
  private LabeledValueBean<Long> schoolYear;

  public SchoolSemesterResponseBean() {}

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public LocalDate getStartDate() {
    return startDate;
  }

  public void setStartDate(LocalDate startDate) {
    this.startDate = startDate;
  }

  public LocalDate getEndDate() {
    return endDate;
  }

  public void setEndDate(LocalDate endDate) {
    this.endDate = endDate;
  }

  public LabeledValueBean<Long> getSchoolYear() {
    return schoolYear;
  }

  public void setSchoolYear(LabeledValueBean<Long> schoolYear) {
    this.schoolYear = schoolYear;
  }
}
