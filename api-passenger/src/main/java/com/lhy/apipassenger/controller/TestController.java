package com.lhy.apipassenger.controller;

import com.lhy.apipassenger.remote.ServiceOrderClient;
import com.lhy.internalcommon.dto.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/test")
    public String test(){

        return "test api passenger";
    }

    /**
     * 需要有token
     * @return
     */
    @GetMapping("/authTest")
    public ResponseResult authTest(){
        return ResponseResult.success("auth test");
    }

    /**
     * 没有token也能正常返回
     * @return
     */
    @GetMapping("/noauthTest")
    public ResponseResult noauthTest(){
        return ResponseResult.success("noauth test");
    }

    @Autowired
    ServiceOrderClient serviceOrderClient;

    /**
     * 测试派单逻辑
     * @param orderId
     * @return
     */
    @GetMapping("/test-real-time-order/{orderId}")
    public String dispatchRealTimeOrder(@PathVariable("orderId") long orderId){
        System.out.println("并发测试：api-passenger："+orderId);
        serviceOrderClient.dispatchRealTimeOrder(orderId);
        return "test-real-time-order   success";
    }
}
