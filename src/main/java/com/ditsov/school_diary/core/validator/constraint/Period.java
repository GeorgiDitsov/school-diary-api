package com.ditsov.school_diary.core.validator.constraint;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;
import com.ditsov.school_diary.core.validator.PeriodValidator;

@Documented
@Retention(RUNTIME)
@Target({TYPE, FIELD})
@Constraint(validatedBy = {PeriodValidator.class})
public @interface Period {

  boolean nullable() default false;

  String message() default "Start date have to be before end date";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}
