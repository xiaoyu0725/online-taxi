package com.lhy.apiDriver.service;

import com.lhy.apiDriver.remote.ServiceDriverUserClient;
import com.lhy.apiDriver.remote.ServiceVerificationcodeClient;
import com.lhy.internalcommon.constant.CommonStatusEnum;
import com.lhy.internalcommon.constant.DriverCarConstants;
import com.lhy.internalcommon.constant.IdentityConstants;
import com.lhy.internalcommon.constant.TokenConstants;
import com.lhy.internalcommon.dto.ResponseResult;
import com.lhy.internalcommon.responese.DriverUserExistsResponse;
import com.lhy.internalcommon.responese.NumberCodeResponse;
import com.lhy.internalcommon.responese.TokenResponse;
import com.lhy.internalcommon.util.JwtUtils;
import com.lhy.internalcommon.util.RedisPrefixUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class VerificationCodeService {

    @Autowired
    ServiceDriverUserClient serviceDriverUserClient;

    @Autowired
    ServiceVerificationcodeClient serviceVerificationcodeClient;

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    public ResponseResult checkAndsendVerificationCode(String driverPhone){
        // 查询 service-driver-user，该手机号的司机是否存在
        ResponseResult<DriverUserExistsResponse> driverUserExistsResponseResponseResult = serviceDriverUserClient.checkDriver(driverPhone);
        DriverUserExistsResponse data = driverUserExistsResponseResponseResult.getData();
        int ifExists = data.getIfExists();
        if (ifExists == DriverCarConstants.DRIVER_NOT_EXISTS){
            return ResponseResult.fail(CommonStatusEnum.DRIVER_NOT_EXITST.getCode(),CommonStatusEnum.DRIVER_NOT_EXITST.getValue());
        }
        log.info(driverPhone+" 的司机存在");
        // 获取验证码
        ResponseResult<NumberCodeResponse> numberCodeResult = serviceVerificationcodeClient.getNumberCode(6);
        NumberCodeResponse numberCodeResponse = numberCodeResult.getData();
        int numberCode = numberCodeResponse.getNumberCode();
        log.info("验证码"+numberCode);
        // 调用第三方发生验证码,第三方：阿里短信服务，腾讯，华信，容联

        // 存入reids。1：key，2：存入value
        String key = RedisPrefixUtils.generatorKeyByPhone(driverPhone, IdentityConstants.DRIVER_IDENTITY);
        stringRedisTemplate.opsForValue().set(key, numberCode+"", 2, TimeUnit.MINUTES);

        return ResponseResult.success("");
    }



    /**
     * 校验验证码
     * @param driverPhone 手机号
     * @param verificationCode 验证码
     * @return
     */
    public ResponseResult checkCode(String driverPhone , String verificationCode){
        // 根据手机号，去redis读取验证码
        // 生成key
        String key = RedisPrefixUtils.generatorKeyByPhone(driverPhone,IdentityConstants.DRIVER_IDENTITY) ;
        // 根据key获取value
        String codeRedis = stringRedisTemplate.opsForValue().get(key);
        System.out.println("redis中的value："+codeRedis);

        // 校验验证码
        if (StringUtils.isBlank(codeRedis)){
            return ResponseResult.fail(CommonStatusEnum.VERIFICATION_CODE_ERROR.getCode(),CommonStatusEnum.VERIFICATION_CODE_ERROR.getValue());
        }
        if (!verificationCode.trim().equals(codeRedis.trim())){
            return ResponseResult.fail(CommonStatusEnum.VERIFICATION_CODE_ERROR.getCode(),CommonStatusEnum.VERIFICATION_CODE_ERROR.getValue());
        }

        // 颁发令牌，不应该用魔法值，用常量
        String accessToken = JwtUtils.generatorToken(driverPhone, IdentityConstants.DRIVER_IDENTITY, TokenConstants.ACCESS_TOKEN_TYPE);
        String refreshToken = JwtUtils.generatorToken(driverPhone, IdentityConstants.DRIVER_IDENTITY ,TokenConstants.REFRESH_TOKEN_TYPE);

        // 将token存到redis当中
        String accessTokenKey = RedisPrefixUtils.generatorTokenKey(driverPhone , IdentityConstants.DRIVER_IDENTITY , TokenConstants.ACCESS_TOKEN_TYPE);
        stringRedisTemplate.opsForValue().set(accessTokenKey , accessToken , 30, TimeUnit.DAYS);

        String refreshTokenKey = RedisPrefixUtils.generatorTokenKey(driverPhone , IdentityConstants.DRIVER_IDENTITY , TokenConstants.REFRESH_TOKEN_TYPE);
        stringRedisTemplate.opsForValue().set(refreshTokenKey , refreshToken , 31, TimeUnit.DAYS);

        // 响应
        TokenResponse tokenResponse = new TokenResponse();
        tokenResponse.setAccessToken(accessToken);
        tokenResponse.setRefreshToken(refreshToken);
        return ResponseResult.success(tokenResponse);
    }
}
