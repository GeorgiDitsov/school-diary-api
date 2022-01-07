package com.ditsov.school_diary.core.factory.common;

import java.time.LocalDate;
import com.ditsov.school_diary.model.common.PeriodBean;

public interface PeriodBeanFactory {

  /**
   * Creates a {@link PeriodBean}.
   *
   * @param startDate
   * @param endDate
   * @return
   */
  PeriodBean createPeriodBean(final LocalDate startDate, final LocalDate endDate);
}
