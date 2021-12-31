package com.ditsov.school_diary.core.factory.common;

import com.ditsov.school_diary.model.common.LabeledValueBean;

public interface LabeledValueFactory {

  LabeledValueBean create(final String label, final Long value);
}
