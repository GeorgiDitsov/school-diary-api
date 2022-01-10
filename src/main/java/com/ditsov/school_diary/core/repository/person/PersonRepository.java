package com.ditsov.school_diary.core.repository.person;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ditsov.school_diary.core.entity.person.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

  Optional<Person> findByUserId(final Long userId);
}
