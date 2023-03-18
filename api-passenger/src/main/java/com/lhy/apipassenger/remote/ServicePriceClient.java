package com.lhy.apipassenger.remote;

import com.lhy.internalcommon.dto.ResponseResult;
import com.lhy.internalcommon.request.ForecastPriceDTO;
import com.lhy.internalcommon.responese.ForecastPriceResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("service-price")
public interface ServicePriceClient {

    @RequestMapping(method = RequestMethod.POST, value = "/forecast-price")
    public ResponseResult<ForecastPriceResponse> forecast(@RequestBody ForecastPriceDTO forecastPriceDTO);
}
