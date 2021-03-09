package com.gildata.xiza.demo.controller;

import com.gildata.xiza.demo.service.PurchaseService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @description 购买业务控制层
 * @author xiza@gildata.com
 * @date 2021/3/9
 */
@RestController
public class PurchaseController {
    @Autowired
    PurchaseService purchaseService = null;

    /**
     * 定义Jsp视图
     */
    @GetMapping("/test")
    public ModelAndView testPage(){
        ModelAndView mv = new ModelAndView("test");
        return mv;
    }

    /**
     * 响应jsp post提交请求
     */
    @PostMapping("/purchase")
    public Result purchase(Long userId, Long productId, Integer quantity) {
        // 采用redis缓存保证高并发的稳定性
        boolean success = purchaseService.purchaseRedis(userId, productId, quantity);
        String message = success ? "抢购成功" : "抢购失败";
        Result result = new Result(success, message);
        return result;
    }

    /**
     * Result响应结果类
     */
    @NoArgsConstructor
    @AllArgsConstructor
    @Data
    class Result{
        private boolean success = false;
        private String message = null;
    }
}


