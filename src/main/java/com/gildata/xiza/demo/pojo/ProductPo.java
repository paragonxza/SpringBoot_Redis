package com.gildata.xiza.demo.pojo;

import lombok.Data;
import org.apache.ibatis.type.Alias;
import java.io.Serializable;

/**
 * 产品Pojo
 * @author paragon
 */
@Data
@Alias("product")
public class ProductPo implements Serializable {
    private static final long serialVersionUID = 8081693425330236833L;
    private Long id;
    private String productName;
    private int stock;
    private double price;
    /**
     * 采用版本号控制实现CAS
     */
    private int version;
    private String note;
}
