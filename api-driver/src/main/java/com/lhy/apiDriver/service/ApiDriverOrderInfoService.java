package com.lhy.apiDriver.service;

import com.lhy.apiDriver.remote.ServiceOrderClient;
import com.lhy.internalcommon.constant.IdentityConstants;
import com.lhy.internalcommon.dto.OrderInfo;
import com.lhy.internalcommon.dto.ResponseResult;
import com.lhy.internalcommon.request.OrderRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;


@Service
public class ApiDriverOrderInfoService {

    @Autowired
    ServiceOrderClient serviceOrderClient;

    public ResponseResult toPickUpPassenger(OrderRequest orderRequest){
        return serviceOrderClient.toPickUpPassenger(orderRequest);
    }

    public ResponseResult arrivedDeparture(OrderRequest orderRequest){
        return serviceOrderClient.arrivedDeparture(orderRequest);
    }

    /**
     * 司机接到乘客
     * @param orderRequest
     * @return
     */
    public ResponseResult pickUpPassenger(@RequestBody OrderRequest orderRequest){
        return  serviceOrderClient.pickUpPassenger(orderRequest);
    }

    public ResponseResult passengerGetoff(OrderRequest orderRequest){
        return serviceOrderClient.passengerGetoff(orderRequest);
    }

    public ResponseResult cancel(Long orderId){
        return  serviceOrderClient.cancel(orderId, IdentityConstants.DRIVER_IDENTITY);
    }

    public ResponseResult<OrderInfo> detail(Long orderId){
        return serviceOrderClient.detail(orderId);
    }


    public ResponseResult<OrderInfo> currentOrder(String phone , String identity){
        return serviceOrderClient.current(phone,identity);
    }
}
