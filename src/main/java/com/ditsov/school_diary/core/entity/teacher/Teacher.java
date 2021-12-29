package com.ditsov.school_diary.core.entity.teacher;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import com.ditsov.school_diary.core.entity.person.Person;
import com.ditsov.school_diary.core.entity.school.subject.SchoolSubject;

@Entity
@Table(name = "teacher")
@PrimaryKeyJoinColumn(name = "teacher_id")
public class Teacher extends Person {

  @ManyToMany
  @JoinTable(
      name = "teacher_school_subject",
      joinColumns = @JoinColumn(name = "teacher_id", referencedColumnName = "teacher_id"),
      inverseJoinColumns =
          @JoinColumn(name = "school_subject_id", referencedColumnName = "school_subject_id"))
  private Set<SchoolSubject> schoolSubjects = new HashSet<>();

  public Teacher() {}

  public Set<SchoolSubject> getSchoolSubjects() {
    return schoolSubjects;
  }

  public void setSchoolSubjects(Set<SchoolSubject> schoolSubjects) {
    this.schoolSubjects = schoolSubjects;
  }
}
