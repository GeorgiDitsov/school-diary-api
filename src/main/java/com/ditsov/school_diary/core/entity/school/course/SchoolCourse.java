package com.ditsov.school_diary.core.entity.school.course;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import com.ditsov.school_diary.core.entity.school.group.SchoolGroup;
import com.ditsov.school_diary.core.entity.school.semester.SchoolSemester;
import com.ditsov.school_diary.core.entity.school.subject.SchoolSubject;
import com.ditsov.school_diary.core.entity.teacher.Teacher;

@Entity
@Table(name = "school_course")
public class SchoolCourse {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "school_course_id_generator")
  @SequenceGenerator(
      name = "school_course_id_generator",
      sequenceName = "school_course_id_sequence",
      allocationSize = 1)
  @Column(name = "school_course_id", updatable = false)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "school_subject_id", referencedColumnName = "school_subject_id")
  private SchoolSubject schoolSubject;

  @ManyToOne
  @JoinColumn(name = "teacher_id", referencedColumnName = "teacher_id")
  private Teacher teacher;

  @ManyToOne
  @JoinColumn(name = "school_group_id", referencedColumnName = "school_group_id")
  private SchoolGroup schoolGroup;

  @ManyToOne
  @JoinColumn(name = "school_semester_id", referencedColumnName = "school_semester_id")
  private SchoolSemester schoolSemester;

  public SchoolCourse() {}

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public SchoolSubject getSchoolSubject() {
    return schoolSubject;
  }

  public void setSchoolSubject(SchoolSubject schoolSubject) {
    this.schoolSubject = schoolSubject;
  }

  public Teacher getTeacher() {
    return teacher;
  }

  public void setTeacher(Teacher teacher) {
    this.teacher = teacher;
  }

  public SchoolGroup getSchoolGroup() {
    return schoolGroup;
  }

  public void setSchoolGroup(SchoolGroup schoolGroup) {
    this.schoolGroup = schoolGroup;
  }

  public SchoolSemester getSchoolSemester() {
    return schoolSemester;
  }

  public void setSchoolSemester(SchoolSemester schoolSemester) {
    this.schoolSemester = schoolSemester;
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
    SchoolCourse other = (SchoolCourse) obj;
    if (id == null) {
      if (other.id != null) return false;
    } else if (!id.equals(other.id)) return false;
    return true;
  }
}
