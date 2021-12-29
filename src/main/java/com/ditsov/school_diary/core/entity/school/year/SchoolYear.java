package com.ditsov.school_diary.core.entity.school.year;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "school_year")
public class SchoolYear {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "school_year_id_generator")
  @SequenceGenerator(
      name = "school_year_id_generator",
      sequenceName = "school_year_id_sequence",
      allocationSize = 1)
  @Column(name = "school_year_id", updatable = false)
  private Long id;

  @Column(name = "name", nullable = false, unique = true)
  private String name;

  @CreationTimestamp
  @Column(name = "created_at", nullable = false)
  private LocalDate createdAt;

  @UpdateTimestamp
  @Column(name = "updated_at", nullable = false)
  private LocalDate updatedAt;

  public SchoolYear() {}

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
    SchoolYear other = (SchoolYear) obj;
    if (id == null) {
      if (other.id != null) return false;
    } else if (!id.equals(other.id)) return false;
    return true;
  }
}
