package com.lhy.apiDriver.controller;

import com.lhy.apiDriver.service.VerificationCodeService;
import com.lhy.internalcommon.dto.ResponseResult;
import com.lhy.internalcommon.request.VerificationCodeDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class VerificationCodeController {

    @Autowired
    VerificationCodeService verificationCodeService;

    @PostMapping("/verification-code")
    public ResponseResult verificationCode(@RequestBody VerificationCodeDTO verificationCodeDTO){
        String driverPhone = verificationCodeDTO.getDriverPhone();
        log.info("司机的号码："+driverPhone);
        return verificationCodeService.checkAndsendVerificationCode(driverPhone);
    }



    @PostMapping("/verification-code-check")
    public ResponseResult checkVerificationCode(@RequestBody VerificationCodeDTO verificationCodeDTO){

        String driverPhone = verificationCodeDTO.getDriverPhone();
        String verificationCode = verificationCodeDTO.getVerificationCode();

        System.out.println("手机号"+driverPhone+",验证码："+verificationCode);

        return verificationCodeService.checkCode(driverPhone,verificationCode);
    }
}
