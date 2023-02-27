package com.mashibing.apidriver.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    /**
     * 需要授权的接口
     * @return
     */
    @GetMapping("/auth")
    public String testAuth(){
        return "auth";
    }

    //不需要授权的接口
    @GetMapping("/noauth")
    public String testNuAuth(){
        return "no auth";
    }
}
