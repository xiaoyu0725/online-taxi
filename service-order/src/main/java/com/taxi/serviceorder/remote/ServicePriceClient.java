package com.taxi.serviceorder.remote;

import com.taxi.internalcommon.dto.PriceRule;
import com.taxi.internalcommon.dto.ResponseResult;
import com.taxi.internalcommon.request.PriceRulesNewRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient("service-price")
public interface ServicePriceClient {

    @PostMapping("/price-rule/is-new")
    public ResponseResult<Boolean> isNew(@RequestBody PriceRulesNewRequest priceRulesNewRequest);

    @GetMapping("/price-rule/if-exists")
    public ResponseResult<Boolean> ifPriceExists(@RequestBody PriceRule priceRule);

    @RequestMapping(method = RequestMethod.POST,value = "/calculate-price")
    public ResponseResult<Double> calculatePrice(@RequestParam Integer distance, @RequestParam Integer duration,@RequestParam String cityCode,@RequestParam String vehicleType);
}
