package com.ditsov.school_diary.core.validator.constraint;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;
import com.ditsov.school_diary.core.validator.PatternValidator;

@Documented
@Retention(RUNTIME)
@Target({FIELD, METHOD})
@Constraint(validatedBy = PatternValidator.class)
public @interface Pattern {

  Regexp regexp() default Regexp.DEFAULT;

  boolean nullable() default false;

  String message() default "Invalid input";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};

  public static enum Regexp {
    DEFAULT("(.*?)"),
    USERNAME("^([a-zA-Z0-9]{5,20})$"),
    PASSWORD("^(?=.*[a-zA-Z0-9])[a-zA-Z0-9]{5,60}$"),
    EMAIL("^([a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6})$"),
    NAME("^([A-Z]{1}[a-z]{1,24})$"),
    PIN("^([0-9]{2}([0][1-9]|[1][0-2])([0][1-9]|[1-2][0-9]|[3][0-1])([0-9]){4})$"),
    SCHOOL_GROUP_INDEX("^([A-Z]{1})$"),
    SCHOOL_SUBJECT_NAME("^([a-zA-Z0-9]{2,50})$");

    private String value;

    private Regexp(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }
  }
}
