package com.lhy.serviceDriverUser.controller;

import com.lhy.internalcommon.dto.Car;
import com.lhy.internalcommon.dto.ResponseResult;
import com.lhy.serviceDriverUser.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CarController {

    @Autowired
    CarService carService;

    @PostMapping("/car")
    public ResponseResult addCar(@RequestBody Car car){
        return carService.addCar(car);
    }

    @GetMapping("/car")
    public ResponseResult<Car> getCarById(int carId){

        return carService.getCarById(carId);
    }
}
