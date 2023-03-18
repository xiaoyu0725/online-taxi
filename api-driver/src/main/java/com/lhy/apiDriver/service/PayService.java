package com.lhy.apiDriver.service;

import com.lhy.apiDriver.remote.ServiceOrderClient;
import com.lhy.apiDriver.remote.ServiceSsePushClient;
import com.lhy.internalcommon.constant.IdentityConstants;
import com.lhy.internalcommon.dto.ResponseResult;
import com.lhy.internalcommon.request.OrderRequest;
import com.lhy.internalcommon.request.PushRequest;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PayService {

    @Autowired
    ServiceSsePushClient serviceSsePushClient;

    @Autowired
    ServiceOrderClient serviceOrderClient;

    public ResponseResult pushPayInfo(int orderId, String price,int passengerId){
        // 封装消息
        JSONObject message = new JSONObject();
        message.put("price",price);
        message.put("orderId",orderId);
        // 修改订单状态
        OrderRequest orderRequest = new OrderRequest();
        orderRequest.setOrderId(orderId);
        serviceOrderClient.pushPayInfo(orderRequest);

        PushRequest pushRequest = new PushRequest();
        pushRequest.setContent(message.toString());
        pushRequest.setUserId(passengerId);
        pushRequest.setIdentity(IdentityConstants.PASSENGER_IDENTITY);

        // 推送消息
        serviceSsePushClient.push(pushRequest);

        return ResponseResult.success();
    }
}
