package com.lhy.apiBoss.service;

import com.lhy.apiBoss.remote.ServiceDriverUserClient;
import com.lhy.internalcommon.dto.Car;
import com.lhy.internalcommon.dto.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarService {

    @Autowired
    ServiceDriverUserClient serviceDriverUserClient;

    public ResponseResult addCar(Car car){
        return serviceDriverUserClient.addCar(car);
    }
}
