package com.ditsov.school_diary.core.repository.school.semester;

import java.time.LocalDate;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.ditsov.school_diary.core.entity.school.semester.SchoolSemester;

@Repository
public interface SchoolSemesterRepository extends JpaRepository<SchoolSemester, Long> {

  @Query(
      "SELECT schoolSemester "
          + "FROM SchoolSemester schoolSemester "
          + "WHERE schoolSemester.startDate <= :date "
          + "AND schoolSemester.endDate >= :date")
  Optional<SchoolSemester> findByDate(final LocalDate date);
}
