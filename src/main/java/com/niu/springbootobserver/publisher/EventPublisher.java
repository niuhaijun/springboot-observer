package com.niu.springbootobserver.publisher;

import java.lang.reflect.Constructor;
import java.util.concurrent.Executor;
import java.util.function.Consumer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.stereotype.Component;

/**
 * 发布事件
 *
 * @Author: niuhaijun
 * @Date: 2019-08-06 13:37
 * @Version 1.0
 */
@Slf4j
@Component
public class EventPublisher implements ApplicationEventPublisherAware {

  private Executor executor;

  public EventPublisher() {

    this(new SimpleAsyncTaskExecutor());
  }

  public EventPublisher(Executor executor) {

    this.executor = executor;
  }

  private ApplicationEventPublisher applicationEventPublisher;

  @Override
  public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {

    this.applicationEventPublisher = applicationEventPublisher;
  }

  private void publishEvent(ApplicationEvent applicationEvent) {

    applicationEventPublisher.publishEvent(applicationEvent);
  }

  public void publishAsync(ApplicationEvent customEvent) {

    executor.execute(() -> publishEvent(customEvent));
  }

  public <T extends ApplicationEvent> void publicAsync(Class<T> eventClass, Object source,
      Consumer<T> wrapperEvent) {

    publish(eventClass, source, wrapperEvent);
  }

  public void publish(ApplicationEvent customEvent) {

    publishEvent(customEvent);
  }

  public <T extends ApplicationEvent> void publish(
      Class<T> eventClass, Object source, Consumer<T> wrapperEvent) {

    T lazyEvent = createInstance(eventClass, source);
    if (wrapperEvent != null) {
      wrapperEvent.accept(lazyEvent);
    }
    publishEvent(lazyEvent);
  }

  /**
   * create instance
   */
  private <T extends ApplicationEvent> T createInstance(Class<T> eventClass, Object source) {

    try {
      Constructor<T> constructor = eventClass.getConstructor(Object.class);
      return constructor.newInstance(source);
    }
    catch (Exception e) {
      log.error("error get instance......\n{}", e.toString());
    }
    return null;
  }
}
