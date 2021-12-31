package com.ditsov.school_diary.core.repository.school.group;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ditsov.school_diary.core.entity.school.group.SchoolGroup;

@Repository
public interface SchoolGroupRepository extends JpaRepository<SchoolGroup, Long> {}
