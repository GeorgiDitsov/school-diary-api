package com.ditsov.school_diary.core.repository.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ditsov.school_diary.core.entity.student.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {}
