package com.lhy.serviceprice.controller;

import com.lhy.internalcommon.dto.ResponseResult;
import com.lhy.internalcommon.request.ForecastPriceDTO;
import com.lhy.serviceprice.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ForecastPriceController {

    @Autowired
    private PriceService forecastPriceService;

    /**
     * 计算预估价格
     * @param forecastPriceDTO
     * @return
     */
    @PostMapping("/forecast-price")
    public ResponseResult forecastPrice(@RequestBody ForecastPriceDTO forecastPriceDTO){

        String depLongitude = forecastPriceDTO.getDepLongitude();
        String depLatitude = forecastPriceDTO.getDepLatitude();
        String destLongitude = forecastPriceDTO.getDestLongitude();
        String destLatitude = forecastPriceDTO.getDestLatitude();
        String cityCode = forecastPriceDTO.getCityCode();
        String vehicleType = forecastPriceDTO.getVehicleType();


        return forecastPriceService.forecastPrice(depLongitude,depLatitude,destLongitude,destLatitude,cityCode,vehicleType);
    }

    /**
     * 计算实际价格
     * @param distance
     * @param duration
     * @param cityCode
     * @param vehicleType
     * @return
     */
    @PostMapping("/calculate-price")
    public ResponseResult<Double> calculatePrice(@RequestParam Integer distance , @RequestParam Integer duration, @RequestParam String cityCode, @RequestParam String vehicleType){
        return forecastPriceService.calculatePrice(distance,duration,cityCode,vehicleType);
    }
}
