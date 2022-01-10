package com.ditsov.school_diary.core.repository.school.course;

import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ditsov.school_diary.core.entity.school.course.SchoolCourse;

@Repository
public interface SchoolCourseRepository extends JpaRepository<SchoolCourse, Long> {

  List<SchoolCourse> findAllByTeacherIdAndSchoolSemesterId(
      final Long teacherId, final Long schoolSemesterId, final Sort sort);

  List<SchoolCourse> findAllBySchoolGroupIdAndSchoolSemesterId(
      final Long schoolGroupId, final Long schoolSemesterId, final Sort sort);
}
