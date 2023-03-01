package com.taxi.serviceverificationcode.controller;

import com.taxi.internalcommon.dto.ResponseResult;
import com.taxi.internalcommon.response.NumberCodeResponse;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NumberCodeController {

    @PostMapping("/numberCode/{size}")
    public ResponseResult numberCode(@PathVariable("size") int size) {
        System.out.println("size"+size);

        //生成验证码
        double mathRandom = (Math.random() * 9 + 1) * Math.pow(10,size - 1);
        System.out.println(mathRandom);
        int resultInt = (int) mathRandom;
        System.out.println("generator src code:" +resultInt);

        //定义返回值
        NumberCodeResponse response = new NumberCodeResponse();
        response.setNumberCode(resultInt);



        return ResponseResult.success(response);
    }

    public static void main(String[] args) {
        //获取随机数
        double mathRandom = (Math.random() * 9 + 1) * Math.pow(10,5);
        System.out.println(mathRandom);
        int resultInt = (int) mathRandom;
        System.out.println(resultInt);


    }
}
