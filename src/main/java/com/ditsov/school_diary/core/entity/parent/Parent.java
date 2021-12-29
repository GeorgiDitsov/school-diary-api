package com.ditsov.school_diary.core.entity.parent;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import com.ditsov.school_diary.core.entity.person.Person;

@Entity
@Table(name = "parent")
@PrimaryKeyJoinColumn(name = "parent_id")
public class Parent extends Person {

  public Parent() {}
}
