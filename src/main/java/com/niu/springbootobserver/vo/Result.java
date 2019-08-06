package com.niu.springbootobserver.vo;

import lombok.Data;

/**
 * @Author: niuhaijun
 * @Date: 2019-08-06 13:45
 * @Version 1.0
 */
@Data
public class Result {

  private Integer code = 200;
  private Object result;
  private String message = "success";

  public Result() {

  }

  public Result(Object result) {

    this.result = result;
  }

  public Result(int code, String message) {

    this.code = code;
    this.message = message;
  }

}
