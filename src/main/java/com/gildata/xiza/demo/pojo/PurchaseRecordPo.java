package com.gildata.xiza.demo.pojo;

import lombok.Data;
import org.apache.ibatis.type.Alias;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @description Purchase对应的实体类
 * @author xiza@gildata.comgon
 * @date 2021/3/9
 */
@Alias("purchaseRecord")
@Data
public class PurchaseRecordPo implements Serializable {
    /**
     * 序列化
     */
    private static final long serialVersionUID = 5119436580597993995L;
    /**
     * 编号
     */
    private Long id;
    /**
     * 用户编号
     */
    private Long userId;
    /**
     * 产品编号
     */
    private Long productId;
    /**
     * 购买价格
     */
    private double price;
    /**
     * 购买数量
     */
    private int quantity;
    /**
     * 购买总价：计算公式 sum = price * quantity
     */
    private double sum;
    /**
     * 购买日期时间戳
     */
    private Timestamp purchaseTime;
    /**
     * 备注信息
     */
    private String note;
}
