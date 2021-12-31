package com.ditsov.school_diary.core.repository.school.semester;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ditsov.school_diary.core.entity.school.semester.SchoolSemester;

@Repository
public interface SchoolSemesterRepository extends JpaRepository<SchoolSemester, Long> {}
