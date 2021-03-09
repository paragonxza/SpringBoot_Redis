package com.gildata.xiza.demo.dao;

import com.gildata.xiza.demo.pojo.PurchaseRecordPo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * @description Purchase对应的dao层
 * @author xiza@gildata.com
 * @date 2021/3/8
 */
@Mapper
@Component("purchaseRecordDao")
public interface PurchaseRecordDao {

    /**
     * 插入购买记录
     * @param pr 购买记录po
     * @return int
     */
    public int insertPurchaseRecord(PurchaseRecordPo pr);
}
