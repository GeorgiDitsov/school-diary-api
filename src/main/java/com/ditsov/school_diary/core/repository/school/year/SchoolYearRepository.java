package com.ditsov.school_diary.core.repository.school.year;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ditsov.school_diary.core.entity.school.year.SchoolYear;

@Repository
public interface SchoolYearRepository extends JpaRepository<SchoolYear, Long> {}
