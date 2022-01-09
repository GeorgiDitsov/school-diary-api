package com.ditsov.school_diary.core.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import com.ditsov.school_diary.core.validator.constraint.SchoolSemester;
import com.ditsov.school_diary.model.common.PeriodableBean;

public class SchoolSemesterValidator
    implements ConstraintValidator<SchoolSemester, PeriodableBean> {

  private boolean nullable;

  @Override
  public void initialize(SchoolSemester constraintAnnotation) {
    ConstraintValidator.super.initialize(constraintAnnotation);
    this.nullable = constraintAnnotation.nullable();
  }

  @Override
  public boolean isValid(PeriodableBean value, ConstraintValidatorContext context) {
    return nullable;
  }
}
