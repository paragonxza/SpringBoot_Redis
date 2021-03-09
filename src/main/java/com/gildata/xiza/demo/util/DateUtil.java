package com.gildata.xiza.demo.util;

import lombok.extern.slf4j.Slf4j;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @description 日期工具类
 * @author xiza@gildata.comgon
 * @date 2021/3/8
 */
@Slf4j
public class DateUtil {

    private static DateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * 根据字符串解析时间
     *
     * @param time String类型时间参数
     * @return Date
     */
    public static Date getTime(String time) throws ParseException {
        try {
            Date date = dateFormat2.parse(time);
            return date;
        }catch (ParseException e){
            log.error("日期解析错误：",e);
            return null;
        }
    }

}
