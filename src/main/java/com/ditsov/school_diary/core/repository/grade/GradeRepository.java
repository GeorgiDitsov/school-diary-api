package com.ditsov.school_diary.core.repository.grade;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.ditsov.school_diary.core.entity.grade.Grade;
import com.ditsov.school_diary.model.grade.GradeStatistics;

@Repository
public interface GradeRepository extends JpaRepository<Grade, Long> {

  List<Grade> findAllBySchoolCourseIdOrderByUpdatedAtDesc(final Long schoolCourseId);

  @Query(
      "SELECT new com.ditsov.school_diary.model.grade.GradeStatistics(student.id, schoolCourse.id, AVG(grade.value)) "
          + "FROM Grade grade "
          + "INNER JOIN grade.student student "
          + "INNER JOIN grade.schoolCourse schoolCourse "
          + "GROUP BY student.id, schoolCourse.id "
          + "HAVING student.id = :studentId")
  List<GradeStatistics> findGradeStatisticsByStudentId(final Long studentId);

  @Query(
      "SELECT new com.ditsov.school_diary.model.grade.GradeStatistics(student.id, schoolCourse.id, AVG(grade.value)) "
          + "FROM Grade grade "
          + "INNER JOIN grade.student student "
          + "INNER JOIN grade.schoolCourse schoolCourse "
          + "GROUP BY student.id, schoolCourse.id "
          + "HAVING schoolCourse.id = :schoolCourseId")
  List<GradeStatistics> findGradeStatisticsBySchoolCourseId(final Long schoolCourseId);

  @Query(
      nativeQuery = true,
      value =
          "SELECT AVG(averages) "
              + "FROM ("
              + "   SELECT grade.student_id, grade.school_course_id, AVG(grade.value) as averages "
              + "   FROM grade "
              + "   GROUP BY grade.student_id, grade.school_course_id "
              + "   HAVING grade.student_id = :studentId"
              + ") as avgs")
  Double getAverageByStudentId(final Long studentId);

  @Query(
      nativeQuery = true,
      value =
          "SELECT AVG(averages) "
              + "FROM ("
              + "   SELECT grade.student_id, grade.school_course_id, AVG(grade.value) as averages "
              + "   FROM grade "
              + "   GROUP BY grade.student_id, grade.school_course_id "
              + "   HAVING grade.school_course_id = :schoolCourseId"
              + ") as avgs")
  Double getAverageBySchoolCourseId(final Long schoolCourseId);
}
