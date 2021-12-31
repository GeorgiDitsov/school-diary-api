package com.ditsov.school_diary.core.repository.school.subject;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ditsov.school_diary.core.entity.school.subject.SchoolSubject;

@Repository
public interface SchoolSubjectRepository extends JpaRepository<SchoolSubject, Long> {}
