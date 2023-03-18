package com.lhy.serviceDriverUser.controller;


import com.lhy.internalcommon.dto.ResponseResult;
import com.lhy.internalcommon.dto.DriverCarBindingRelationship;
import com.lhy.serviceDriverUser.service.DriverCarBindingRelationshipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 晁鹏飞
 * @since 2022-08-13
 */
@RestController
@RequestMapping("/driver-car-binding-relationship")
public class DriverCarBindingRelationshipController {

    @Autowired
    DriverCarBindingRelationshipService driverCarBindingRelationshipService;

    @PostMapping("/bind")
    public ResponseResult bind(@RequestBody DriverCarBindingRelationship driverCarBindingRelationship){

        return driverCarBindingRelationshipService.bind(driverCarBindingRelationship);
    }

    @PostMapping("/unbind")
    public ResponseResult unbind(@RequestBody DriverCarBindingRelationship driverCarBindingRelationship){
        return driverCarBindingRelationshipService.unbind(driverCarBindingRelationship);

    }

}
