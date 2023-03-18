package com.lhy.serviceverificationcode.controller;

import com.lhy.internalcommon.dto.ResponseResult;
import com.lhy.internalcommon.responese.NumberCodeResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NumberCodeController {

    @GetMapping("/numberCode/{size}")
    public ResponseResult numberCode(@PathVariable("size") int size){

        System.out.println("size:"+size);
        // 生成验证码
        double mathRandom = (Math.random()*9 + 1) * (Math.pow(10,size-1));
        System.out.println(mathRandom);
        int resultInt = (int)mathRandom;
        System.out.println("generator src code:"+resultInt);

        // 定义返回值
        NumberCodeResponse response = new NumberCodeResponse();
        response.setNumberCode(resultInt);

        return ResponseResult.success(response);
    }


}
