package com.ditsov.school_diary.core.validator.constraint;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;
import com.ditsov.school_diary.core.validator.SchoolCourseValidator;

@Documented
@Retention(RUNTIME)
@Target({TYPE, FIELD})
@Constraint(validatedBy = {SchoolCourseValidator.class})
public @interface SchoolCourse {

  boolean nullable() default false;

  String message() default "Invalid school course";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}
