package com.ditsov.school_diary.core.validator.constraint;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import javax.validation.Payload;

@Documented
@Retention(RUNTIME)
@Target({TYPE, FIELD, METHOD})
public @interface SchoolSemester {

  boolean nullable() default false;

  String message() default "Invalid school semester";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}
