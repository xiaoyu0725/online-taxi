package com.lhy.apipassenger.controller;

import com.lhy.apipassenger.service.VerificationCodeService;
import com.lhy.internalcommon.dto.ResponseResult;
import com.lhy.internalcommon.request.VerificationCodeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VerificationCodeController {

    @Autowired
    private VerificationCodeService verificationCodeService;

    @PostMapping("/verification-code")
    public ResponseResult verificationCode(@RequestBody VerificationCodeDTO verificationCodeDTO){

        String passengerPhone = verificationCodeDTO.getPassengerPhone();
        return verificationCodeService.generatorCode(passengerPhone);

    }

    @PostMapping("/verification-code-check")
    public ResponseResult checkVerificationCode(@RequestBody VerificationCodeDTO verificationCodeDTO){

        String passengerPhone = verificationCodeDTO.getPassengerPhone();
        String verificationCode = verificationCodeDTO.getVerificationCode();

        System.out.println("手机号"+passengerPhone+",验证码："+verificationCode);

        return verificationCodeService.checkCode(passengerPhone,verificationCode);
    }

}
