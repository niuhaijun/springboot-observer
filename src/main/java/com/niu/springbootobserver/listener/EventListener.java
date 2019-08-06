package com.niu.springbootobserver.listener;

import com.niu.springbootobserver.event.Event;
import com.niu.springbootobserver.handler.EventHandler;
import java.util.List;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.core.annotation.AnnotationAwareOrderComparator;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

/**
 * 事件监听
 *
 * @Author: niuhaijun
 * @Date: 2019-08-06 13:45
 * @Version 1.0
 */
@Component
public class EventListener implements ApplicationListener<Event>,
    InitializingBean {

  @Autowired(required = false)
  private List<EventHandler> handlers;

  @Override
  public void onApplicationEvent(Event event) {

    handlers.forEach(handler -> handler.handle(event));
  }

  @Override
  public void afterPropertiesSet() {

    if (!CollectionUtils.isEmpty(handlers)) {
      AnnotationAwareOrderComparator.sort(handlers);
    }
  }
}
