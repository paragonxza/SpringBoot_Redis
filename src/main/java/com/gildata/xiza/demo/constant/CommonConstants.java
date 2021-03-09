package com.gildata.xiza.demo.constant;

/**
 * @description 公共常量定义文件
 * @author xiza@gildata.com
 * @date 2021/3/9
 */
public class CommonConstants {

    /**
     *  定义定时调度任务的Set集合
     */
    public static final String PRODUCT_SCHEDULE_SET = "product_schedule_set";
    /**
     *  定义Redis缓存存放的购买产品List列表
     */
    public static final String PURCHASE_PRODUCT_LIST = "purchase_list_";
    /**
     *  每次取出1000条，避免一次取出消耗太多内存
     */
    public static final int ONE_TIME_SIZE = 1000;

    /**
     * 正则表达式匹配规则
     */

    /**
     * integer (-MAX, MAX)
     */
    public final static String REGEX_INTEGER = "^[-\\+]?\\d+$";

    /**
     * integer [1, MAX)
     */
    public final static String REGEX_POSITIVE_INTEGER = "^\\+?[1-9]\\d*$";

    /**
     * integer (-MAX, -1]
     */
    public final static String REGEX_NEGATIVE_INTEGER = "^-[1-9]\\d*$";

    /**
     * integer [0, MAX), only numeric
     */
    public final static String REGEX_NUMERIC = "^\\d+$";

    /**
     * decimal (-MAX, MAX)
     */
    public final static String REGEX_DECIMAL = "^[-\\+]?\\d+\\.\\d+$";

    /**
     * decimal (0.0, MAX)
     */
    public final static String REGEX_POSITIVE_DECIMAL = "^\\+?([1-9]+\\.\\d+|0\\.\\d*[1-9])$";

    /**
     * decimal (-MAX, -0.0)
     */
    public final static String REGEX_NEGATIVE_DECIMAL = "^-([1-9]+\\.\\d+|0\\.\\d*[1-9])$";

    /**
     * decimal + integer (-MAX, MAX)
     */
    public final static String REGEX_REAL_NUMBER = "^[-\\+]?(\\d+|\\d+\\.\\d+)$";

    /**
     * decimal + integer [0, MAX)
     */
    public final static String REGEX_NON_NEGATIVE_REAL_NUMBER = "^\\+?(\\d+|\\d+\\.\\d+)$";

    /**
     * decimal + integer (-MAX, MAX) + %
     */
    public final static String REGEX_REAL_NUMBER_PERCENT = "^[-\\+]?(\\d+|\\d+\\.\\d+)%$";

    /**
     * 未知
     */
    public static final String UNKNOWN = "unknown";

    /**
     * X-Forwarded-For
     */
    public static final String X_FORWARDED_FOR = "X-Forwarded-For";

    /**
     * Proxy-Client-IP
     */
    public static final String PROXY_CLIENT_IP = "Proxy-Client-IP";

    /**
     * WL-Proxy-Client-IP
     */
    public static final String WL_PROXY_CLIENT_IP = "WL-Proxy-Client-IP";

    /**
     * HTTP_CLIENT_IP
     */
    public static final String HTTP_CLIENT_IP = "HTTP_CLIENT_IP";

    /**
     * X-Real-IP
     */
    public static final String X_REAL_IP = "X-Real-IP";

}
