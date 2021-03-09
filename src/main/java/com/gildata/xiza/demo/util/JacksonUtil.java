package com.gildata.xiza.demo.util;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.extern.slf4j.Slf4j;

/**
 * @description Json工具类
 * @author xiza@gildata.comgon
 * @date 2021/3/8
 */
@Slf4j
public class JacksonUtil {

    private static ObjectMapper mapper = new ObjectMapper()
            //设置空值不需要转换
            .enable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
            .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
            .enable(MapperFeature.USE_ANNOTATIONS);

    /**
     * Json转换为String
     *
     * @return
     */
    public static String toJsonString(Object object) {
        return toJsonString(object, mapper);
    }

    /**
     * Json转换为String
     *
     * @return
     */
    public static String toJsonString(Object object, ObjectMapper objectMapper) {
        String res = null;
        try {
            res = objectMapper.writeValueAsString(object);
        } catch (Exception e) {
            res = null;
        }
        return res;
    }

    /**
     * Json转换为java对象
     *
     * @return
     */
    public static <T> T toJavaObject(String json, Class<T> itemType) {
        return toJavaObject(json, mapper, itemType);
    }

    /**
     * Json转换为java对象
     *
     * @return
     */
    public static <T> T toJavaObject(String json, ObjectMapper objectMapper, Class<T> itemType) {
        T t = null;
        try {
            t = objectMapper.readValue(json, itemType);
        } catch (Exception e) {
            log.error("转换失败:{}", e);
            t = null;
        }
        return t;
    }

}
