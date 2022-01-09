package com.ditsov.school_diary.core.factory.common.impl;

import java.util.stream.Collectors;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import com.ditsov.school_diary.core.factory.AbstractFactory;
import com.ditsov.school_diary.core.factory.common.PageableBeanFactory;
import com.ditsov.school_diary.model.common.PageableBean;

@Component
public class PageableBeanFactoryImpl implements PageableBeanFactory {

  /** @see PageableBeanFactory#create(Page) */
  @Override
  public <T, E> PageableBean<T> create(
      final Page<E> page, final AbstractFactory<T, E> abstractFactory) {
    PageableBean<T> bean = new PageableBean<>();

    bean.setItems(
        page.getContent()
            .stream()
            .map(abstractFactory::convertToResponseBean)
            .collect(Collectors.toList()));
    bean.setPages(page.getTotalPages());

    return bean;
  }

}
