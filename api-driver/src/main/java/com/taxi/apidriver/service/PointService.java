package com.taxi.apidriver.service;

import com.taxi.apidriver.remote.ServiceDriverUserClient;
import com.taxi.apidriver.remote.ServiceMapClient;
import com.taxi.internalcommon.dto.Car;
import com.taxi.internalcommon.dto.ResponseResult;
import com.taxi.internalcommon.request.ApiDriverPointRequest;
import com.taxi.internalcommon.request.PointRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PointService {

    @Autowired
    private ServiceMapClient serviceMapClient;

    @Autowired
    private ServiceDriverUserClient serviceDriverUserClient;

    public ResponseResult upload(ApiDriverPointRequest apiDriverPointRequest){
        //获取 carId
        Long carId = apiDriverPointRequest.getCarId();
        //通过catId,获取 tid、trid 调用service_driver_user的接口
        ResponseResult<Car> carById = serviceDriverUserClient.getCarById(carId);
        Car car = carById.getData();
        String tid = car.getTid();
        String trid = car.getTrid();
        //调用地图去上传
        PointRequest pointRequest = new PointRequest();
        pointRequest.setTid(tid);
        pointRequest.setTrid(trid);
        pointRequest.setPoints(apiDriverPointRequest.getPoints());

        return serviceMapClient.upload(pointRequest);
    }
}
