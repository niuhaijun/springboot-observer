package com.niu.springbootobserver.handler;

import com.niu.springbootobserver.event.Event;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @Author: niuhaijun
 * @Date: 2019-08-06 13:54
 * @Version 1.0
 */
@Component
@Order(2)
@Slf4j
public class ComplexEventHandler extends AbstractEventHandler {

  @Override
  void execute(Event event) {

    log.info("ComplexEventHandler 处理事件, 任务ID: {}", event.getTaskId());
  }
}