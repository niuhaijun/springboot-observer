package com.niu.springbootobserver.handler;

import com.niu.springbootobserver.event.Event;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * data process parent
 *
 * @Author: niuhaijun
 * @Date: 2019-08-06 13:45
 * @Version 1.0
 */
@Component
@Order(1)
@Slf4j
public class SimpleEventHandler extends AbstractEventHandler {

  @Override
  void execute(Event event) {

    log.info("SimpleEventHandler  处理事件, 任务ID: {}", event.getTaskId());
  }
}
