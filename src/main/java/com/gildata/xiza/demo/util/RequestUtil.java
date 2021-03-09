package com.gildata.xiza.demo.util;

import com.gildata.xiza.demo.constant.CommonConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * @description Request请求工具类
 * @author xiza@gildata.comgon
 * @date 2021/3/8
 */
@Slf4j
public class RequestUtil {

  /**
   * 获取真实用户ip
   *
   * @return
   */
  public static String getIp() {

    HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    String ip = null;

    //X-Forwarded-For：Squid 服务代理
    String ipAddresses = request.getHeader(CommonConstants.X_FORWARDED_FOR);

    if (ipAddresses == null || ipAddresses.length() == 0 || CommonConstants.UNKNOWN.equalsIgnoreCase(ipAddresses)) {
      //Proxy-Client-IP：apache 服务代理
      ipAddresses = request.getHeader(CommonConstants.PROXY_CLIENT_IP);
    }

    if (ipAddresses == null || ipAddresses.length() == 0 || CommonConstants.UNKNOWN.equalsIgnoreCase(ipAddresses)) {
      //WL-Proxy-Client-IP：weblogic 服务代理
      ipAddresses = request.getHeader(CommonConstants.WL_PROXY_CLIENT_IP);
    }

    if (ipAddresses == null || ipAddresses.length() == 0 || CommonConstants.UNKNOWN.equalsIgnoreCase(ipAddresses)) {
      //HTTP_CLIENT_IP：有些代理服务器
      ipAddresses = request.getHeader(CommonConstants.HTTP_CLIENT_IP);
    }

    if (ipAddresses == null || ipAddresses.length() == 0 || CommonConstants.UNKNOWN.equalsIgnoreCase(ipAddresses)) {
      //X-Real-IP：nginx服务代理
      ipAddresses = request.getHeader(CommonConstants.X_REAL_IP);
    }

    //有些网络通过多层代理，那么获取到的ip就会有多个，一般都是通过逗号（,）分割开来，并且第一个ip为客户端的真实IP
    if (ipAddresses != null && ipAddresses.length() != 0) {
      ip = ipAddresses.split(",")[0];
    }

    //还是不能获取到，最后再通过request.getRemoteAddr();获取
    if (ip == null || ip.length() == 0 || CommonConstants.UNKNOWN.equalsIgnoreCase(ipAddresses)) {
      ip = request.getRemoteAddr();
    }
    if (log.isDebugEnabled()) {
      Enumeration<String> headerNames = request.getHeaderNames();
      while (headerNames.hasMoreElements()) {
        String headerName = headerNames.nextElement();
        log.debug("header【{}】:{}", headerName, request.getHeader(headerName));
      }
    }
    return ip;
  }
}
