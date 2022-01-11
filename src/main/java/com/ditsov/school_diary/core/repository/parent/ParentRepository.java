package com.ditsov.school_diary.core.repository.parent;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ditsov.school_diary.core.entity.parent.Parent;

@Repository
public interface ParentRepository extends JpaRepository<Parent, Long> {

  Optional<Parent> findByUserId(final Long userId);
}
