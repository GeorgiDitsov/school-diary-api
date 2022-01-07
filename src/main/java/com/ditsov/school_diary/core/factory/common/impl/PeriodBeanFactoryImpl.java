package com.ditsov.school_diary.core.factory.common.impl;

import java.time.LocalDate;
import org.springframework.stereotype.Component;
import com.ditsov.school_diary.core.factory.common.PeriodBeanFactory;
import com.ditsov.school_diary.model.common.PeriodBean;

@Component
public class PeriodBeanFactoryImpl implements PeriodBeanFactory {

  /** @see PeriodBeanFactory#createPeriodBean(LocalDate, LocalDate) */
  @Override
  public PeriodBean createPeriodBean(final LocalDate startDate, final LocalDate endDate) {
    PeriodBean periodBean = new PeriodBean();

    periodBean.setStartDate(startDate);
    periodBean.setEndDate(endDate);

    return periodBean;
  }
}
