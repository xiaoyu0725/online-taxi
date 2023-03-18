package com.lhy.serviceorder.remote;

import com.lhy.internalcommon.dto.Car;
import com.lhy.internalcommon.dto.ResponseResult;
import com.lhy.internalcommon.responese.OrderDriverResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("service-driver-user")
public interface ServiceDriverUserClient {

    @GetMapping("/city-driver/is-alailable-driver")
    public ResponseResult<Boolean> isAvailableDriver(@RequestParam String cityCode);

    @GetMapping("/get-available-driver/{carId}")
    public ResponseResult<OrderDriverResponse> getAvailableDriver(@PathVariable("carId") int carId);

    @GetMapping("/car")
    public ResponseResult<Car> getCarById(@RequestParam  int carId);
}
