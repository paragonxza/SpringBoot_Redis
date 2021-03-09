package com.gildata.xiza.demo.log;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;

import org.apache.commons.lang3.exception.ExceptionUtils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

/**
 * @description: 资源文件对应日志
 * @author xiza@gildata.comgon
 * @date 2021/3/8
 */
@Slf4j
public class RcLog {

    private static final Logger eslog = LogManager.getLogger("ESLogger");
    private static com.gildata.xiza.demo.util.RequestUtil RequestUtil;

    public static void info(Object msg) {
      info(msg, null);
    }

    public static void error(Object msg) {
      error(msg, null);
    }

    public static void error(Object msg, Throwable e) {
      error(msg, null, e);
    }

    public static void warn(Object msg) {
      warn(msg, null);
    }

    public static void info(Object msg, String module) {
      eslog.info(build(msg, module));
    }

    public static void error(Object msg, String module, Throwable e) {
        String str = build(msg, module, e);
        eslog.error(lineHandle(str));
        log.error(System.currentTimeMillis() + "", e);
    }

    public static void warn(Object msg, String module) {
        String str = build(msg, module);
        eslog.warn(lineHandle(str));
    }

    public static String lineHandle(String json) {
        try {
          json = json.replaceAll(System.lineSeparator(), "\t")
              + System.lineSeparator();
        } catch (Exception e) {
          return e.getMessage();
        }
        return json;
    }

    public static String build(Object msg, String module) {
      return build(msg, module, null);
    }

    public static String build(Object msg, String module, Throwable e) {
        RcLogMsg logMsg = RcLogMsg.builder()
            .msg(msg instanceof String ? msg : JSON.toJSONString(msg))
            .module(module)
            .time(System.currentTimeMillis())
            .exception(Objects.isNull(e) ? null : ExceptionUtils.getStackTrace(e))
            .build();
        try {
            HttpServletRequest request = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
            logMsg.setUri(request.getRequestURI());
            logMsg.setIp(com.gildata.xiza.demo.util.RequestUtil.getIp());
            logMsg.setSource(request.getHeader("source"));
        } catch (Exception ignored) { }
        return JSON.toJSONString(logMsg);
    }

}
