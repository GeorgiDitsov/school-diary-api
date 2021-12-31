package com.ditsov.school_diary.core.entity.student;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import com.ditsov.school_diary.core.entity.parent.Parent;
import com.ditsov.school_diary.core.entity.person.Person;
import com.ditsov.school_diary.core.entity.school.group.SchoolGroup;

@Entity
@Table(name = "student")
@PrimaryKeyJoinColumn(name = "student_id")
public class Student extends Person {

  @ManyToOne
  @JoinColumn(name = "school_group_id", referencedColumnName = "school_group_id")
  private SchoolGroup schoolGroup;

  @ManyToMany
  @JoinTable(
      name = "parent_student",
      joinColumns = @JoinColumn(name = "student_id", referencedColumnName = "student_id"),
      inverseJoinColumns = @JoinColumn(name = "parent_id", referencedColumnName = "parent_id"))
  private Set<Parent> parents = new HashSet<>();

  public Student() {}

  public SchoolGroup getSchoolGroup() {
    return schoolGroup;
  }

  public void setSchoolGroup(SchoolGroup schoolGroup) {
    this.schoolGroup = schoolGroup;
  }

  public Set<Parent> getParents() {
    return parents;
  }

  public void setParents(Set<Parent> parents) {
    this.parents = parents;
  }
}
