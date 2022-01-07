package com.ditsov.school_diary.core.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import com.ditsov.school_diary.core.validator.constraint.Pattern;

public class PatternValidator implements ConstraintValidator<Pattern, String> {

  private String regexp;
  private boolean nullable;

  @Override
  public void initialize(Pattern constraintAnnotation) {
    ConstraintValidator.super.initialize(constraintAnnotation);
    this.regexp = constraintAnnotation.regexp().getValue();
    this.nullable = constraintAnnotation.nullable();
  }

  @Override
  public boolean isValid(String value, ConstraintValidatorContext context) {
    return nullable ? value == null || value.matches(regexp) : value.matches(regexp);
  }
}
