package com.niu.springbootobserver.service.impl;


import com.niu.springbootobserver.event.Event;
import com.niu.springbootobserver.publisher.EventPublisher;
import com.niu.springbootobserver.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @Author: niuhaijun
 * @Date: 2019-08-06 13:45
 * @Version 1.0
 */
@Service
public class EventServiceImpl implements EventService {

  @Autowired
  private EventPublisher eventPublisher;


  @Override
  public void createResultData(String taskId) {

    eventPublisher.publish(Event.class, this, event -> event.setTaskId(taskId));
  }
}
