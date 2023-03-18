package com.lhy.pay.service;

import com.lhy.internalcommon.request.OrderRequest;
import com.lhy.pay.remote.ServiceOrderClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlipayService {

    @Autowired
    ServiceOrderClient serviceOrderClient;

    public void pay(int orderId){
        OrderRequest orderRequest = new OrderRequest();
        orderRequest.setOrderId(orderId);
        serviceOrderClient.pay(orderRequest);

    }
}
