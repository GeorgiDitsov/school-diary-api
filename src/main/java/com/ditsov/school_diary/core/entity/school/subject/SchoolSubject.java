package com.ditsov.school_diary.core.entity.school.subject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "school_subject")
public class SchoolSubject {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "school_subject_id_generator")
  @SequenceGenerator(
      name = "school_subject_id_generator",
      sequenceName = "school_subject_id_sequence",
      allocationSize = 1)
  @Column(name = "school_subject_id", updatable = false)
  private Long id;

  @Column(name = "name", nullable = false, unique = true)
  private String name;

  public SchoolSubject() {}

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
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
    SchoolSubject other = (SchoolSubject) obj;
    if (id == null) {
      if (other.id != null) return false;
    } else if (!id.equals(other.id)) return false;
    return true;
  }
}
