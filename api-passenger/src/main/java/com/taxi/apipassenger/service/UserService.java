package com.taxi.apipassenger.service;

import com.taxi.apipassenger.remote.ServicePassengerUserClient;
import com.taxi.internalcommon.dto.PassengerUser;
import com.taxi.internalcommon.dto.ResponseResult;
import com.taxi.internalcommon.dto.TokenResult;
import com.taxi.internalcommon.util.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserService {

    @Autowired
    ServicePassengerUserClient servicePassengerUserClient;

    public ResponseResult getUserByAccessToken(String accessToken) {
        log.info("accessToken：" + accessToken);
        //解析accessToken拿到手机号
        TokenResult tokenResult = JwtUtils.checkToken(accessToken);
        String phone = tokenResult.getPhone();
        log.info("手机号:"+phone);

        //根据手机号，查询用户信息
        ResponseResult<PassengerUser> userByPhone = servicePassengerUserClient.getUserByPhone(phone);


        return ResponseResult.success(userByPhone.getData());
    }
}
