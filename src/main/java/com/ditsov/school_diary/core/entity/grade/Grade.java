package com.ditsov.school_diary.core.entity.grade;

import java.time.LocalDate;
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
  private LocalDate createdAt;

  @UpdateTimestamp
  @Column(name = "updated_at", nullable = false)
  private LocalDate updatedAt;

  @ManyToOne
  @JoinColumn(name = "student_id", referencedColumnName = "student_id")
  private Student student;

  @ManyToOne
  @JoinColumn(name = "school_course_id", referencedColumnName = "school_course_id")
  private SchoolCourse schoolCourse;

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

  public LocalDate getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(LocalDate createdAt) {
    this.createdAt = createdAt;
  }

  public LocalDate getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(LocalDate updatedAt) {
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