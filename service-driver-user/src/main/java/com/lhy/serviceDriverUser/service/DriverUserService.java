package com.lhy.serviceDriverUser.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lhy.internalcommon.constant.CommonStatusEnum;
import com.lhy.internalcommon.constant.DriverCarConstants;
import com.lhy.internalcommon.dto.*;
import com.lhy.internalcommon.responese.OrderDriverResponse;
import com.lhy.serviceDriverUser.mapper.CarMapper;
import com.lhy.serviceDriverUser.mapper.DriverCarBindingRelationshipMapper;
import com.lhy.serviceDriverUser.mapper.DriverUserMapper;
import com.lhy.serviceDriverUser.mapper.DriverUserWorkStatusMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DriverUserService {

    @Autowired
    private DriverUserMapper driverUserMapper;

    @Autowired
    private DriverUserWorkStatusMapper driverUserWorkStatusMapper;

    @Autowired
    private CarMapper carMapper;

    public ResponseResult testGetDriverUser(){

        DriverUser driverUser = driverUserMapper.selectById(1);
        return ResponseResult.success(driverUser);

    }

    public ResponseResult addDriverUser(DriverUser driverUser){
        LocalDateTime now = LocalDateTime.now();
        driverUser.setGmtCreate(now);
        driverUser.setGmtModified(now);

        driverUserMapper.insert(driverUser);
        // 初始化 司机工作状态表
        DriverUserWorkStatus driverUserWorkStatus = new DriverUserWorkStatus();
        driverUserWorkStatus.setDriverId(driverUser.getId());
        driverUserWorkStatus.setWorkStatus(DriverCarConstants.DRIVER_WORK_STATUS_STOP);
        driverUserWorkStatus.setGmtModified(now);
        driverUserWorkStatus.setGmtCreate(now);
        driverUserWorkStatusMapper.insert(driverUserWorkStatus);


        return ResponseResult.success("");
    }

    public ResponseResult updateDriverUser(DriverUser driverUser){
        LocalDateTime now = LocalDateTime.now();
        driverUser.setGmtModified(now);
        driverUserMapper.updateById(driverUser);
        return ResponseResult.success("");
    }


    public ResponseResult<DriverUser> getDriverUserByPhone(String driverPhone){
        Map<String,Object> map = new HashMap<>();
        map.put("driver_phone", driverPhone);
        map.put("state", DriverCarConstants.DRIVER_STATE_VALID);
        List<DriverUser> driverUsers = driverUserMapper.selectByMap(map);
        if (driverUsers.isEmpty()){
            return ResponseResult.fail(CommonStatusEnum.DRIVER_NOT_EXITST.getCode(),CommonStatusEnum.DRIVER_NOT_EXITST.getValue());
        }
        DriverUser driverUser = driverUsers.get(0);
        return ResponseResult.success(driverUser);
    }

    @Autowired
    DriverCarBindingRelationshipMapper driverCarBindingRelationshipMapper;

    public ResponseResult<OrderDriverResponse> getAvailableDriver(int carId){
        // 车辆和司机绑定关系查询
        QueryWrapper<DriverCarBindingRelationship> driverCarBindingRelationshipQueryWrapper = new QueryWrapper<>();
        driverCarBindingRelationshipQueryWrapper.eq("car_id",carId);
        driverCarBindingRelationshipQueryWrapper.eq("bind_state",DriverCarConstants.DRIVER_CAR_BIND);

        DriverCarBindingRelationship driverCarBindingRelationship = driverCarBindingRelationshipMapper.selectOne(driverCarBindingRelationshipQueryWrapper);
        int driverId = driverCarBindingRelationship.getDriverId();
        // 司机工作状态的查询
        QueryWrapper<DriverUserWorkStatus> driverUserWorkStatusQueryWrapper = new QueryWrapper<>();
        driverUserWorkStatusQueryWrapper.eq("driver_id",driverId);
        driverUserWorkStatusQueryWrapper.eq("work_status",DriverCarConstants.DRIVER_WORK_STATUS_START);

        DriverUserWorkStatus driverUserWorkStatus = driverUserWorkStatusMapper.selectOne(driverUserWorkStatusQueryWrapper);
        if (null == driverUserWorkStatus){
            return ResponseResult.fail(CommonStatusEnum.AVAILABLE_DRIVER_EMPTY.getCode(),CommonStatusEnum.AVAILABLE_DRIVER_EMPTY.getValue());

        }else {
            // 查询司机信息
            QueryWrapper<DriverUser> driverUserQueryWrapper = new QueryWrapper<>();
            driverUserQueryWrapper.eq("id",driverId);
            DriverUser driverUser = driverUserMapper.selectOne(driverUserQueryWrapper);
            // 查询车辆信息
            QueryWrapper<Car> carQueryWrapper = new QueryWrapper<>();
            carQueryWrapper.eq("id",carId);
            Car car = carMapper.selectOne(carQueryWrapper);


            OrderDriverResponse orderDriverResponse = new OrderDriverResponse();
            orderDriverResponse.setCarId(carId);
            orderDriverResponse.setDriverId(driverId);
            orderDriverResponse.setDriverPhone(driverUser.getDriverPhone());

            orderDriverResponse.setLicenseId(driverUser.getLicenseId());
            orderDriverResponse.setVehicleNo(car.getVehicleNo());
            orderDriverResponse.setVehicleType(car.getVehicleType());

            return ResponseResult.success(orderDriverResponse);
        }
    }



}