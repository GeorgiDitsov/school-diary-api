package com.ditsov.school_diary.core.repository.role;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ditsov.school_diary.core.entity.role.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {}
