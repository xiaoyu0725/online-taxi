package com.lhy.servicemap.controller;

import com.lhy.internalcommon.dto.ResponseResult;
import com.lhy.internalcommon.request.ForecastPriceDTO;
import com.lhy.servicemap.service.DirectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/direction")
public class DriectionController {

    @Autowired
    private DirectionService directionService;

    @GetMapping("/driving")
    public ResponseResult driving(@RequestBody ForecastPriceDTO forecastPriceDTO){

        String depLongitude = forecastPriceDTO.getDepLongitude();
        String depLatitude = forecastPriceDTO.getDepLatitude();
        String destLongitude = forecastPriceDTO.getDestLongitude();
        String destLatitude = forecastPriceDTO.getDestLatitude();

        return directionService.driving(depLongitude,depLatitude,destLongitude,destLatitude);
    }
}
