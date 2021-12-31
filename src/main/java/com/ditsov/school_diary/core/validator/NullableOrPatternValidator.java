package com.ditsov.school_diary.core.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import com.ditsov.school_diary.core.validator.constraint.NullableOrPattern;

public class NullableOrPatternValidator implements ConstraintValidator<NullableOrPattern, String> {

  private String regexp;

  @Override
  public void initialize(NullableOrPattern constraintAnnotation) {
    ConstraintValidator.super.initialize(constraintAnnotation);
    this.regexp = constraintAnnotation.regexp();
  }

  @Override
  public boolean isValid(String value, ConstraintValidatorContext context) {
    return value == null || value.matches(regexp);
  }
}
