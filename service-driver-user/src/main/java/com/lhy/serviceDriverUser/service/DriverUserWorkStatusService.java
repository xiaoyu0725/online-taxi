package com.lhy.serviceDriverUser.service;

import com.lhy.internalcommon.dto.DriverUserWorkStatus;
import com.lhy.internalcommon.dto.ResponseResult;
import com.lhy.serviceDriverUser.mapper.DriverUserWorkStatusMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 晁鹏飞
 * @since 2022-09-17
 */
@Service
public class DriverUserWorkStatusService{

    @Autowired
    DriverUserWorkStatusMapper driverUserWorkStatusMapper;

    public ResponseResult changeWorkStatus(Long driverId, Integer workStatus){

        Map<String,Object> queryMap = new HashMap<>();
        queryMap.put("driver_id",driverId);
        List<DriverUserWorkStatus> driverUserWorkStatuses = driverUserWorkStatusMapper.selectByMap(queryMap);
        DriverUserWorkStatus driverUserWorkStatus = driverUserWorkStatuses.get(0);

        driverUserWorkStatus.setWorkStatus(workStatus);

        driverUserWorkStatusMapper.updateById(driverUserWorkStatus);

        return ResponseResult.success("");

    }

    public ResponseResult<DriverUserWorkStatus> getWorkStatus(int driverId) {
        Map<String,Object> queryMap = new HashMap<>();
        queryMap.put("driver_id",driverId);
        List<DriverUserWorkStatus> driverUserWorkStatuses = driverUserWorkStatusMapper.selectByMap(queryMap);
        DriverUserWorkStatus driverUserWorkStatus = driverUserWorkStatuses.get(0);

        return ResponseResult.success(driverUserWorkStatus);

    }
}
