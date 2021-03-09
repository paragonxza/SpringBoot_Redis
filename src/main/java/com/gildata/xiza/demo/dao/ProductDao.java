package com.gildata.xiza.demo.dao;

import com.gildata.xiza.demo.pojo.ProductPo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * @author paragon
 */
@Mapper
@Component("productDao")
public interface ProductDao {
    //获取产品
    public ProductPo getProduct(Long id);

    /**
     * 减库存，param标明的mybatis参数传递给后台，不采用cas
     * @param id 编号
     * @param quantity 购买数量
     * @return int
     */
    public int decreaseProduct(@Param("id") Long id, @Param("quantity") int quantity);

    /**
     * 减库存，param标明的mybatis参数传递给后台，采用cas
     * @param id 编号
     * @param quantity 购买数量
     * @param version 版本号 实现CAS关键
     * @return int
     */
//    public int decreaseProduct(@Param("id") Long id, @Param("quantity") int quantity, @Param("version") int version);
}
