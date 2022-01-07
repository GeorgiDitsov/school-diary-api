package com.ditsov.school_diary.core.repository.grade;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ditsov.school_diary.core.entity.grade.Grade;

@Repository
public interface GradeRepository extends JpaRepository<Grade, Long> {

  List<Grade> findAllByStudentIdAndSchoolCourseIdOrderByUpdatedAtDesc(final Long studentId, final Long schoolCourseId);
}
