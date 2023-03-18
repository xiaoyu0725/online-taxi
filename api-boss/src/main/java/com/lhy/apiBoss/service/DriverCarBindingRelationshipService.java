package com.lhy.apiBoss.service;

import com.lhy.apiBoss.remote.ServiceDriverUserClient;
import com.lhy.internalcommon.dto.DriverCarBindingRelationship;
import com.lhy.internalcommon.dto.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DriverCarBindingRelationshipService {

    @Autowired
    ServiceDriverUserClient serviceDriverUserClient;


    public ResponseResult bind(DriverCarBindingRelationship driverCarBindingRelationship){
        return serviceDriverUserClient.bind(driverCarBindingRelationship);
    }

    public ResponseResult unbind(DriverCarBindingRelationship driverCarBindingRelationship) {

        return serviceDriverUserClient.unbind(driverCarBindingRelationship);
    }
}
