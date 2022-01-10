package com.ditsov.school_diary.core.repository.teacher;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ditsov.school_diary.core.entity.teacher.Teacher;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {

  Teacher findByUserId(final Long userId);
}
