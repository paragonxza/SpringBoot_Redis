package com.gildata.xiza.demo.log;

import com.alibaba.fastjson.annotation.JSONType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description: 资源文件对应日志实体类
 * @author xiza@gildata.comgon
 * @date 2021/3/8
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JSONType(orders = {"time", "uri", "source", "module", "msg", "ip", "exception"})
public class RcLogMsg {

  /**
   *消息
   */
  private Object msg;

  /**
   *来源
   */
  private String source;

  /**
   *模型
   */
  private String module;

  /**
   *时间
   */
  private Long time;

  /**
   *ip地址
   */
  private String ip;

  /**
   *uri
   */
  private String uri;

  /**
   *异常
   */
  private String exception;

}
