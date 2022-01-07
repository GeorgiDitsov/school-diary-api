package com.ditsov.school_diary.core.service.role.impl;

import javax.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ditsov.school_diary.core.entity.role.Role;
import com.ditsov.school_diary.core.entity.role.RoleName;
import com.ditsov.school_diary.core.repository.role.RoleRepository;
import com.ditsov.school_diary.core.service.role.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

  @Autowired private RoleRepository roleRepository;

  /** @see RoleService#getByName(RoleName) */
  @Override
  public Role getByName(final RoleName name) {
    return roleRepository.findByName(name).orElseThrow(EntityNotFoundException::new);
  }
}
