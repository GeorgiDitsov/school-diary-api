package com.ditsov.school_diary.core.factory.common.impl;

import org.springframework.stereotype.Component;
import com.ditsov.school_diary.core.factory.common.ErrorResponseBeanFactory;
import com.ditsov.school_diary.model.common.ErrorResponseBean;

@Component
public class ErrorResponseBeanFactoryImpl implements ErrorResponseBeanFactory {

  /** @see ErrorResponseBeanFactory#createErrorResponseBean(String, String) */
  @Override
  public ErrorResponseBean createErrorResponseBean(final String code, final String message) {
    ErrorResponseBean bean = new ErrorResponseBean();

    bean.setCode(code);
    bean.setMessage(message);

    return bean;
  }
}
