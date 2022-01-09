package com.ditsov.school_diary.core.entity.grade;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import com.ditsov.school_diary.core.entity.school.course.SchoolCourse;
import com.ditsov.school_diary.core.entity.student.Student;
import com.ditsov.school_diary.core.entity.teacher.Teacher;

@Entity
@Table(name = "grade")
public class Grade {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "grade_id_generator")
  @SequenceGenerator(
      name = "grade_id_generator",
      sequenceName = "grade_id_sequence",
      allocationSize = 1)
  @Column(name = "grade_id", updatable = false)
  private Long id;

  @Column(name = "value", nullable = false)
  private Double value;

  @CreationTimestamp
  @Column(name = "created_at", nullable = false)
  private LocalDateTime createdAt;

  @UpdateTimestamp
  @Column(name = "updated_at", nullable = false)
  private LocalDateTime updatedAt;

  @ManyToOne
  @JoinColumn(name = "student_id", referencedColumnName = "student_id")
  private Student student;

  @ManyToOne
  @JoinColumn(name = "school_course_id", referencedColumnName = "school_course_id")
  private SchoolCourse schoolCourse;

  @ManyToOne
  @JoinColumn(name = "created_by", referencedColumnName = "teacher_id")
  private Teacher createdBy;

  @ManyToOne
  @JoinColumn(name = "updated_by", referencedColumnName = "teacher_id")
  private Teacher updatedBy;

  public Grade() {}

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

  public Student getStudent() {
    return student;
  }

  public void setStudent(Student student) {
    this.student = student;
  }

  public SchoolCourse getSchoolCourse() {
    return schoolCourse;
  }

  public void setSchoolCourse(SchoolCourse schoolCourse) {
    this.schoolCourse = schoolCourse;
  }

  public Teacher getCreatedBy() {
    return createdBy;
  }

  public void setCreatedBy(Teacher createdBy) {
    this.createdBy = createdBy;
  }

  public Teacher getUpdatedBy() {
    return updatedBy;
  }

  public void setUpdatedBy(Teacher updatedBy) {
    this.updatedBy = updatedBy;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null) return false;
    if (getClass() != obj.getClass()) return false;
    Grade other = (Grade) obj;
    if (id == null) {
      if (other.id != null) return false;
    } else if (!id.equals(other.id)) return false;
    return true;
  }
}
