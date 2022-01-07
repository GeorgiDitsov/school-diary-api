package com.ditsov.school_diary.core.service.role;

import com.ditsov.school_diary.core.entity.role.Role;
import com.ditsov.school_diary.core.entity.role.RoleName;

public interface RoleService {

  /**
   * Retrieves role by name.
   *
   * @param name
   * @return
   */
  Role getByName(final RoleName name);
}
