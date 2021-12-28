package com.ditsov.school_diary.core.factory.common;

import com.ditsov.school_diary.model.common.ErrorResponseBean;

public interface ErrorResponseBeanFactory {

  /**
   * Creates an {@link ErrorResponseBean}.
   *
   * @param code
   * @param message
   * @return
   */
  ErrorResponseBean createErrorResponseBean(final String code, final String message);
}
