package com.ditsov.school_diary.core.entity.student;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import com.ditsov.school_diary.core.entity.person.Person;
import com.ditsov.school_diary.core.entity.school.group.SchoolGroup;

@Entity
@Table(name = "student")
@PrimaryKeyJoinColumn(name = "student_id")
public class Student extends Person {

  @ManyToOne
  @JoinColumn(name = "school_group_id", referencedColumnName = "school_group_id")
  private SchoolGroup schoolGroup;

  public Student() {}

  public SchoolGroup getSchoolGroup() {
    return schoolGroup;
  }

  public void setSchoolGroup(SchoolGroup schoolGroup) {
    this.schoolGroup = schoolGroup;
  }
}
