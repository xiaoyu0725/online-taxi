package com.mashibing.apiBoss.service;

import com.mashibing.apiBoss.remote.ServiceDriverUserClient;
import com.mashibing.internalcommon.dto.DriverUser;
import com.mashibing.internalcommon.dto.ResponseResult;
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
