package com.taxi.apiBoss.service;

import com.taxi.apiBoss.remote.ServiceDriverUserClient;
import com.taxi.internalcommon.dto.DriverUser;
import com.taxi.internalcommon.dto.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DriverUserService {

    @Autowired
    private ServiceDriverUserClient ServiceDriverUserClient;

    public ResponseResult addDriverUser(DriverUser driverUser){
        return ServiceDriverUserClient.addDriverUser(driverUser);

    }

    public ResponseResult updateDriverUser(DriverUser driverUser){
        return ServiceDriverUserClient.updateDriverUser(driverUser);
    }
}
