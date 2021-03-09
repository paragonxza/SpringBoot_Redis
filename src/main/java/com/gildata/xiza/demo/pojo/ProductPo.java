package com.gildata.xiza.demo.pojo;

import lombok.Data;
import org.apache.ibatis.type.Alias;
import java.io.Serializable;

/**
 * @description Product对应的实体类
 * @author xiza@gildata.comgon
 * @date 2021/3/9
 */
@Data
@Alias("product")
public class ProductPo implements Serializable {
    /**
     * 序列化
     */
    private static final long serialVersionUID = 8081693425330236833L;
    /**
     * 编号
     */
    private Long id;
    /**
     * 产品名称
     */
    private String productName;
    /**
     * 库存
     */
    private int stock;
    /**
     * 单价
     */
    private double price;
    /**
     * 版本号：采用版本号控制实现CAS
     */
    private int version;
    /**
     * 备注信息
     */
    private String note;
}
