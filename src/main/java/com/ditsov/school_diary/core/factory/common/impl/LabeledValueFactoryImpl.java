package com.ditsov.school_diary.core.factory.common.impl;

import org.springframework.stereotype.Component;
import com.ditsov.school_diary.core.factory.common.LabeledValueFactory;
import com.ditsov.school_diary.model.common.LabeledValueBean;

@Component
public class LabeledValueFactoryImpl implements LabeledValueFactory {

  /** @see LabeledValueFactory#create(String, Long) */
  @Override
  public LabeledValueBean create(final String label, final Long value) {
    LabeledValueBean bean = new LabeledValueBean();

    bean.setLabel(label);
    bean.setValue(value);

    return bean;
  }
}
