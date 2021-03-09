package com.gildata.xiza.demo.service.impl;

import com.gildata.xiza.demo.dao.ProductDao;
import com.gildata.xiza.demo.dao.PurchaseRecordDao;
import com.gildata.xiza.demo.pojo.ProductPo;
import com.gildata.xiza.demo.pojo.PurchaseRecordPo;
import com.gildata.xiza.demo.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PurchaseServiceImpl implements PurchaseService {

    @Autowired
    private ProductDao productDao = null;
    @Autowired
    private PurchaseRecordDao purchaseRecordDao = null;


    @Override
    //启用Spring数据库事务机制
    @Transactional(rollbackFor=Exception.class)
    public boolean purchase(Long userId, Long productId, int quantity) {
        //localtime
        long start = System.currentTimeMillis();
        while (true){
            long end = System.currentTimeMillis();
            if(end - start > 100){
                return false;
            }
            //获取产品
            ProductPo product = productDao.getProduct(productId);
            //比较库存和购买数量
            if (product.getStock() < quantity){
                //库存不足
                return false;
            }
            //扣减库存,原始方法不采用CAS
            //productDao.decreaseProduct(productId, quantity);

            //添加版本号采用CAS实现乐观锁
            //获取当前版本号
            int version = product.getVersion();
            //扣减库存，同时将当前版本号发送给后台进行比对
            int result = productDao.decreaseProduct(productId, quantity, version);
            //如果更新数据失败，则说明数据在多线程中被其他线程修改，导致失败返回
            if(result == 0){
                //return false;
                continue;
            }

            //初始化购买记录
            PurchaseRecordPo pr = this.initPurchaseRecord(userId, product, quantity);
            //插入购买记录
            purchaseRecordDao.insertPurchaseRecord(pr);
            return true;
        }
    }
    //初始化购买信息
    private PurchaseRecordPo initPurchaseRecord(Long userId, ProductPo product, int quantity){
        PurchaseRecordPo pr = new PurchaseRecordPo();
        pr.setNote("购买日志，时间：" + System.currentTimeMillis());
        pr.setPrice(product.getPrice());
        pr.setProductId(product.getId());
        pr.setQuantity(quantity);
        double sum = product.getPrice() * quantity;
        pr.setSum(sum);
        pr.setUserId(userId);
        return pr;
    }
}
