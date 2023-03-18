package com.lhy.apiDriver.controller;

import com.lhy.apiDriver.service.PayService;
import com.lhy.internalcommon.dto.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pay")
public class PayController {

    @Autowired
    PayService payService;

    /**
     * 司机发起收款
     * @param orderId
     * @param price
     * @return
     */
    @PostMapping("/push-pay-info")
    public ResponseResult pushPayInfo(@RequestParam int orderId , @RequestParam String price, @RequestParam int passengerId){

        return payService.pushPayInfo(orderId,price,passengerId);
    }
}
