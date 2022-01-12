package com.ditsov.school_diary.core.repository.grade;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.ditsov.school_diary.core.entity.grade.Grade;
import com.ditsov.school_diary.model.grade.GradeStatistics;

@Repository
public interface GradeRepository extends JpaRepository<Grade, Long> {

  List<Grade> findAllBySchoolCourseIdOrderByUpdatedAtDesc(final Long schoolCourseId);

  List<Grade> findAllByStudentIdAndSchoolCourseSchoolSemesterIdOrderByUpdatedAtDesc(
      final Long studentId, final Long schoolSemesterId);

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
          "SELECT AVG(average) "
              + "FROM ("
              + "       SELECT grade.student_id, grade.school_course_id, AVG(grade.value) as average "
              + "       FROM grade "
              + "       GROUP BY grade.student_id, grade.school_course_id "
              + "       HAVING grade.school_course_id = :schoolCourseId"
              + "     ) as averages")
  Optional<BigDecimal> getSuccessBySchoolCourseId(final Long schoolCourseId);

  @Query(
      nativeQuery = true,
      value =
          "SELECT average "
              + "FROM ("
              + "       SELECT grade.student_id, grade.school_course_id, AVG(grade.value) as average "
              + "       FROM grade "
              + "       GROUP BY grade.student_id, grade.school_course_id "
              + "       HAVING grade.student_id = :studentId "
              + "       AND grade.school_course_id = :schoolCourseId"
              + "     ) as average")
  Optional<BigDecimal> getSuccessByStudentIdAndSchoolCourseId(
      final Long studentId, final Long schoolCourseId);

  @Query(
      nativeQuery = true,
      value =
          "SELECT AVG(average) "
              + "FROM ( "
              + "       SELECT grade.student_id, school_course.school_course_id, school_semester.school_semester_id, AVG(grade.value) as average "
              + "       FROM grade "
              + "       JOIN school_course "
              + "       ON grade.school_course_id = school_course.school_course_id "
              + "       JOIN school_semester "
              + "       ON school_course.school_semester_id = school_semester.school_semester_id "
              + "       GROUP BY grade.student_id, school_course.school_course_id, school_semester.school_semester_id "
              + "       HAVING grade.student_id = :studentId "
              + "       AND school_semester.school_semester_id = :schoolSemesterId"
              + "     ) as averages")
  Optional<BigDecimal> getSuccessByStudentIdAndSchoolSemesterId(
      final Long studentId, final Long schoolSemesterId);
}
