package com.taxi.servicemap.service;

import com.taxi.internalcommon.dto.ResponseResult;
import com.taxi.internalcommon.response.DirectionResponse;
import com.taxi.servicemap.remote.MapDirectionClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DirectionService {

    @Autowired
    private MapDirectionClient MapDirectionClient;

    /**
     * 根据起点经纬度和终点经纬度获取距离（米）和时长（分支）
     * @param depLongitude
     * @param depLatitude
     * @param destLongitude
     * @param destLatitude
     * @return
     */
    public ResponseResult driving(String depLongitude,String depLatitude,String destLongitude,String destLatitude) {

        //调用第三方地图接口
        DirectionResponse direction = MapDirectionClient.direction(depLongitude, depLatitude, destLongitude, destLatitude);

        return ResponseResult.success(direction);
    }
}
