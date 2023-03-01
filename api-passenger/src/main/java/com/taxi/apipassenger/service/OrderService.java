package com.taxi.apipassenger.service;

import com.taxi.apipassenger.remote.ServiceOrderClient;
import com.taxi.internalcommon.constant.IdentityConstants;
import com.taxi.internalcommon.dto.ResponseResult;
import com.taxi.internalcommon.request.OrderRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    ServiceOrderClient serviceOrderClient;
    public ResponseResult add(OrderRequest orderRequest){
        return serviceOrderClient.add(orderRequest);

    }

    /**
     * 取消订单
     * @param orderId
     * @return
     */
    public ResponseResult cancel(Long orderId){
        return serviceOrderClient.cancel(orderId, IdentityConstants.PASSENGER_IDENTITY);
    }
}
