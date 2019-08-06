package com.niu.springbootobserver.handler;


import com.niu.springbootobserver.event.Event;

/**
 * 事件处理器接口
 *
 *
 * @Author: niuhaijun
 * @Date: 2019-08-06 13:45
 * @Version 1.0
 */
public interface EventHandler {

  /**
   * handle data export
   * @param event base event
   */
  void handle(Event event);
}