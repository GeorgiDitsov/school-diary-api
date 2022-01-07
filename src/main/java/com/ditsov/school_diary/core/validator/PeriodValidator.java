package com.ditsov.school_diary.core.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import com.ditsov.school_diary.core.validator.constraint.Period;
import com.ditsov.school_diary.model.common.PeriodBean;

public class PeriodValidator implements ConstraintValidator<Period, PeriodBean> {

  private boolean nullable;

  @Override
  public void initialize(Period constraintAnnotation) {
    ConstraintValidator.super.initialize(constraintAnnotation);
    this.nullable = constraintAnnotation.nullable();
  }

  @Override
  public boolean isValid(PeriodBean value, ConstraintValidatorContext context) {
    return nullable
        ? value == null || value.getStartDate().isBefore(value.getEndDate())
        : value.getStartDate().isBefore(value.getEndDate());
  }
}
