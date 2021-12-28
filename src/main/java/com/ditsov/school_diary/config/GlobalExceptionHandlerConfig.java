package com.ditsov.school_diary.config;

import static org.springframework.http.HttpStatus.NOT_FOUND;
import javax.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.ditsov.school_diary.core.factory.common.ErrorResponseBeanFactory;
import com.ditsov.school_diary.model.common.ErrorResponseBean;

@ControllerAdvice
public class GlobalExceptionHandlerConfig {

  @Autowired private ErrorResponseBeanFactory errorResponseBeanFactory;

  @ExceptionHandler({EntityNotFoundException.class})
  public ResponseEntity<ErrorResponseBean> handleNotFound(final Exception exception) {
    return ResponseEntity.status(NOT_FOUND)
        .body(
            errorResponseBeanFactory.createErrorResponseBean(
                NOT_FOUND.toString(), exception.getMessage()));
  }
}
