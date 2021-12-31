package com.ditsov.school_diary.util;

public interface Regexp {
  public static final String USERNAME_REGEX = "^([a-zA-Z0-9]{5,20})$";
  public static final String PASSWORD_REGEX = "^(?=.*[a-zA-Z0-9])[a-zA-Z0-9]{5,60}$";
  public static final String EMAIL_REGEX = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
}
