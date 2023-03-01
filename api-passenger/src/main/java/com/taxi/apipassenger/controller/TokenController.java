package com.taxi.apipassenger.controller;

import com.taxi.apipassenger.service.TokenService;
import com.taxi.internalcommon.dto.ResponseResult;
import com.taxi.internalcommon.response.TokenResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TokenController {

    @Autowired
    private TokenService tokenService;

    @PostMapping("/token-refresh")
    public ResponseResult refreshToken(@RequestBody TokenResponse tokenResponse){

        String refreshTokenSrc = tokenResponse.getRefreshToken();
        System.out.println("原来的 refreshToken:"+refreshTokenSrc);

        return tokenService.refreshToken(refreshTokenSrc);
    }

}
