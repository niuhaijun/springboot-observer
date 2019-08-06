package com.niu.springbootobserver.event;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;

/**
 * 事件
 *
 * @Author: niuhaijun
 * @Date: 2019-08-06 13:37
 * @Version 1.0
 */
@Getter
@Setter
public class Event extends ApplicationEvent {

  private String taskId;

  public Event(Object source) {

    super(source);
  }

  public Event() {

    super("null");
  }


  @Override
  public String toString() {

    return "Event(taskId=" + this.getTaskId() + ")";
  }
}
