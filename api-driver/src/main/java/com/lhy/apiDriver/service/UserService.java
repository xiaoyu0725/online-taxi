package com.lhy.apiDriver.service;

import com.lhy.apiDriver.remote.ServiceDriverUserClient;
import com.lhy.internalcommon.dto.DriverCarBindingRelationship;
import com.lhy.internalcommon.dto.DriverUser;
import com.lhy.internalcommon.dto.DriverUserWorkStatus;
import com.lhy.internalcommon.dto.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private ServiceDriverUserClient serviceDriverUserClient;

    public ResponseResult updateUser(DriverUser driverUser){
        return serviceDriverUserClient.updateUser(driverUser);
    }

    public ResponseResult changeWorkStatus(DriverUserWorkStatus driverUserWorkStatus){
        return serviceDriverUserClient.changeWorkStatus(driverUserWorkStatus);
    }

    public ResponseResult<DriverCarBindingRelationship> getDriverCarBindingRelationship(String driverPhone){
        // 根据driverPhone查询司机信息
        return serviceDriverUserClient.getDriverCarRelationShip(driverPhone);

    }

    public ResponseResult<DriverUserWorkStatus> getWorkStatus(Long driverId){
        return serviceDriverUserClient.getWorkStatus(driverId);
    }
}
