package com.ditsov.school_diary.model.common;

import java.util.Collection;

public class PageableBean<T> {

  private Collection<T> items;
  private Integer pages;

  public PageableBean() {}

  public Collection<T> getItems() {
    return items;
  }

  public void setItems(Collection<T> items) {
    this.items = items;
  }

  public Integer getPages() {
    return pages;
  }

  public void setPages(Integer pages) {
    this.pages = pages;
  }
}
