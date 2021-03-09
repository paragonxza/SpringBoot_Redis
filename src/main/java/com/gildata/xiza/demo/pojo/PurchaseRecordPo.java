package com.gildata.xiza.demo.pojo;

import lombok.Data;
import org.apache.ibatis.type.Alias;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 购买记录pojo
 * @author paragon
 */
@Alias("purchaseRecord")
@Data
public class PurchaseRecordPo implements Serializable {
    private static final long serialVersionUID = 5119436580597993995L;
    private Long id;
    private Long userId;
    private Long productId;
    private double price;
    private int quantity;
    private double sum;
    /**
     * 添加时间戳
     */
    private Timestamp purchaseTime;
    private String note;
}
