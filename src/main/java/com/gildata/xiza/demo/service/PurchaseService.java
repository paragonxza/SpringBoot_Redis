package com.gildata.xiza.demo.service;

import com.gildata.xiza.demo.pojo.PurchaseRecordPo;

import java.util.List;

/**
 * @author paragon
 */
public interface PurchaseService {
    /**
     * 处理购买业务
     * @param userId 用户编号
     * @param productId 产品编号
     * @param quantity 购买数量
     * @return 成功or失败
     */
    public boolean purchase(Long userId, Long productId, int quantity);

}
