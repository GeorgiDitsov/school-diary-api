package com.ditsov.school_diary.core.repository.grade;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ditsov.school_diary.core.entity.grade.Grade;

@Repository
public interface GradeRepository extends JpaRepository<Grade, Long> {

  Page<Grade> findAllByStudentIdAndSchoolCourseId(
      final Long studentId, final Long schoolCourseId, final Pageable pageable);
}
