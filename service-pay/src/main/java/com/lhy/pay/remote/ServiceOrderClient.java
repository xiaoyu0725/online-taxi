package com.lhy.pay.remote;

import com.lhy.internalcommon.dto.ResponseResult;
import com.lhy.internalcommon.request.OrderRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("service-order")
public interface ServiceOrderClient {

    @RequestMapping(method = RequestMethod.POST, value = "/order/pay")
    public ResponseResult pay(@RequestBody OrderRequest orderRequest);
}
