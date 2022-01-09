package com.ditsov.school_diary.model.grade;

import java.time.LocalDateTime;
import com.ditsov.school_diary.model.common.LabeledValueBean;

public class GradeResponseBean {

  private Long id;
  private Double value;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;
  private LabeledValueBean<Long> student;
  private LabeledValueBean<Long> subject;
  private LabeledValueBean<Long> teacher;

  public GradeResponseBean() {}

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Double getValue() {
    return value;
  }

  public void setValue(Double value) {
    this.value = value;
  }

  public LocalDateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(LocalDateTime createdAt) {
    this.createdAt = createdAt;
  }

  public LocalDateTime getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(LocalDateTime updatedAt) {
    this.updatedAt = updatedAt;
  }

  public LabeledValueBean<Long> getStudent() {
    return student;
  }

  public void setStudent(LabeledValueBean<Long> student) {
    this.student = student;
  }

  public LabeledValueBean<Long> getSubject() {
    return subject;
  }

  public void setSubject(LabeledValueBean<Long> subject) {
    this.subject = subject;
  }

  public LabeledValueBean<Long> getTeacher() {
    return teacher;
  }

  public void setTeacher(LabeledValueBean<Long> teacher) {
    this.teacher = teacher;
  }
}
