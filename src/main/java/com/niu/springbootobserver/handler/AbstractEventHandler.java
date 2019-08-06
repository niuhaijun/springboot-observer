package com.niu.springbootobserver.handler;


import com.niu.springbootobserver.event.Event;

/**
 * 抽象事件处理器
 *
 * @Author: niuhaijun
 * @Date: 2019-08-06 13:45
 * @Version 1.0
 */
public abstract class AbstractEventHandler implements EventHandler {

  @Override
  public void handle(Event event) {

    execute(event);
  }

  abstract void execute(Event event);
}
