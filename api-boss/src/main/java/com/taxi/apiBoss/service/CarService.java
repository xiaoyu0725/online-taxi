package com.taxi.apiBoss.service;

import com.taxi.apiBoss.remote.ServiceDriverUserClient;
import com.taxi.internalcommon.dto.Car;
import com.taxi.internalcommon.dto.ResponseResult;
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
