package com.ditsov.school_diary.core.entity.parent;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import com.ditsov.school_diary.core.entity.person.Person;
import com.ditsov.school_diary.core.entity.student.Student;

@Entity
@Table(name = "parent")
@PrimaryKeyJoinColumn(name = "parent_id")
public class Parent extends Person {

  @ManyToMany(mappedBy = "parents")
  private Set<Student> children = new HashSet<>();

  public Parent() {}

  public Set<Student> getChildren() {
    return children;
  }

  public void setChildren(Set<Student> children) {
    this.children = children;
  }
}
