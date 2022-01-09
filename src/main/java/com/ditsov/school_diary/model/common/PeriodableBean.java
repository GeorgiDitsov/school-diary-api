package com.ditsov.school_diary.model.common;

public abstract class PeriodableBean {

  private PeriodBean period;

  public PeriodBean getPeriod() {
    return period;
  }

  public void setPeriod(PeriodBean period) {
    this.period = period;
  }
}
