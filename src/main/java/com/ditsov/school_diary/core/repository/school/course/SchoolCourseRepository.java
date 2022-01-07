package com.ditsov.school_diary.core.repository.school.course;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ditsov.school_diary.core.entity.school.course.SchoolCourse;

@Repository
public interface SchoolCourseRepository extends JpaRepository<SchoolCourse, Long> {}
