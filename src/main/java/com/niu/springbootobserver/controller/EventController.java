package com.niu.springbootobserver.controller;

import com.niu.springbootobserver.service.EventService;
import com.niu.springbootobserver.vo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @Author: niuhaijun
 * @Date: 2019-08-06 13:45
 * @Version 1.0
 */
@Slf4j
@RestController
@RequestMapping("/data")
public class EventController {

  @Autowired
  private EventService eventService;


  @PostMapping("/resources/{taskId}")
  public Object create(@PathVariable("taskId") String taskId) {

    eventService.createResultData(taskId);
    return new Result();
  }

}
