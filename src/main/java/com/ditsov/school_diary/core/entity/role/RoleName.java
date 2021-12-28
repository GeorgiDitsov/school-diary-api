package com.ditsov.school_diary.core.entity.role;

import org.springframework.security.core.GrantedAuthority;

public enum RoleName implements GrantedAuthority {
  ROLE_ADMIN("ROLE_ADMIN"),
  ROLE_TEACHER("ROLE_TEACHER"),
  ROLE_STUDENT("ROLE_STUDENT"),
  ROLE_PARENT("ROLE_PARENT");

  private String authority;

  private RoleName(String authority) {
    this.authority = authority;
  }

  @Override
  public String getAuthority() {
    return authority;
  }
}
