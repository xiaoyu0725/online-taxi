package com.lhy.serviceDriverUser.controller;


import com.lhy.internalcommon.dto.ResponseResult;
import com.lhy.internalcommon.dto.DriverUserWorkStatus;
import com.lhy.serviceDriverUser.service.DriverUserWorkStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 晁鹏飞
 * @since 2022-09-17
 */
@RestController
public class DriverUserWorkStatusController {

    @Autowired
    DriverUserWorkStatusService driverUserWorkStatusService;

    @PostMapping("/driver-user-work-status")
    public ResponseResult changeWorkStatus(@RequestBody DriverUserWorkStatus driverUserWorkStatus){

        return driverUserWorkStatusService.changeWorkStatus(driverUserWorkStatus.getDriverId(), driverUserWorkStatus.getWorkStatus());
    }

    @GetMapping("/work-status")
    public ResponseResult<DriverUserWorkStatus> getWorkStatus(int driverId){
        return driverUserWorkStatusService.getWorkStatus(driverId);
    }
}
