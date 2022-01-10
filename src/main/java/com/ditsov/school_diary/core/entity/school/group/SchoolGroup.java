package com.ditsov.school_diary.core.entity.school.group;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import com.ditsov.school_diary.core.entity.student.Student;

@Entity
@Table(
    name = "school_group",
    uniqueConstraints = @UniqueConstraint(columnNames = {"year", "letter_index"}))
public class SchoolGroup {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "school_group_id_generator")
  @SequenceGenerator(
      name = "school_group_id_generator",
      sequenceName = "school_group_id_sequence",
      allocationSize = 1)
  @Column(name = "school_group_id", updatable = false)
  private Long id;

  @Column(name = "year", nullable = false)
  private Integer year;

  @Column(name = "letter_index", nullable = false)
  private String index;

  @OneToMany(mappedBy = "schoolGroup")
  private Set<Student> students = new HashSet<>();

  public SchoolGroup() {}

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Integer getYear() {
    return year;
  }

  public void setYear(Integer year) {
    this.year = year;
  }

  public String getIndex() {
    return index;
  }

  public void setIndex(String index) {
    this.index = index;
  }

  public Set<Student> getStudents() {
    return students;
  }

  public void setStudents(Set<Student> students) {
    this.students = students;
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
    SchoolGroup other = (SchoolGroup) obj;
    if (id == null) {
      if (other.id != null) return false;
    } else if (!id.equals(other.id)) return false;
    return true;
  }
}
