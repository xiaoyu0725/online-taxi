package com.taxi.serviceprice.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.taxi.internalcommon.constant.CommonStatusEnum;
import com.taxi.internalcommon.dto.PriceRule;
import com.taxi.internalcommon.dto.ResponseResult;
import com.taxi.internalcommon.request.ForecastPriceDTO;
import com.taxi.internalcommon.response.DirectionResponse;
import com.taxi.internalcommon.response.ForecastPriceResponse;
import com.taxi.internalcommon.util.BigDecimalUtils;
import com.taxi.serviceprice.mapper.PriceRuleMapper;
import com.taxi.serviceprice.remote.ServiceMapClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class PriceService {

    @Autowired
    private ServiceMapClient serviceMapClient;

    @Autowired
    private PriceRuleMapper priceRuleMapper;
    //计算预估价格
    public ResponseResult forecastPrice(String depLongitude, String depLatitude, String destLongitude, String destLatitude,String cityCode,String vehicleType) {

        log.info("出发地的经度："+depLongitude);
        log.info("出发地纬度："+depLatitude);
        log.info("目的地经度："+destLatitude);
        log.info("目的地纬度："+destLongitude);

        log.info("调用地图服务，查询距离和时长");
        ForecastPriceDTO forecastPriceDTO = new ForecastPriceDTO();
        forecastPriceDTO.setDepLongitude(depLongitude);
        forecastPriceDTO.setDepLatitude(depLatitude);
        forecastPriceDTO.setDestLongitude(destLongitude);
        forecastPriceDTO.setDestLatitude(destLatitude);
        ResponseResult<DirectionResponse> direction = serviceMapClient.direction(forecastPriceDTO);
        Integer distance = direction.getData().getDistance();
        Integer duration = direction.getData().getDuration();
        log.info("距离："+distance+",时长"+duration  );

        log.info("读取计价规则");
        Map<String,Object> queryMap = new HashMap<>();
        queryMap.put("city_code",cityCode);
        queryMap.put("vehicle_type",vehicleType);

        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("city_code",cityCode);
        queryWrapper.eq("vehicle_type",vehicleType);
        queryWrapper.orderByDesc("fare_version");

        List<PriceRule> priceRules = priceRuleMapper.selectList(queryWrapper);
        if (priceRules.size() == 0) {
            return ResponseResult.fail(CommonStatusEnum.PRICE_RULE_EMPTY.getCode(),CommonStatusEnum.PRICE_RULE_EMPTY.getValue());
        }
        PriceRule priceRule = priceRules.get(0);

        log.info("根据距离，时长和计价规则，计算价格");

        double price = getPrice(distance, duration, priceRule);


        ForecastPriceResponse forecastPriceResponse = new ForecastPriceResponse();
        forecastPriceResponse.setPrice(price);
        forecastPriceResponse.setCityCode(cityCode);
        forecastPriceResponse.setVehicleType(vehicleType);
        forecastPriceResponse.setFareType(priceRule.getFareType());
        forecastPriceResponse.setFareVersion(priceRule.getFareVersion());

        return ResponseResult.success(forecastPriceResponse);
    }

    public ResponseResult<Double> calculatePrice(Integer distance, Integer duration, String cityCode, String vehicleType){
        //查询计价规则
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("city_code",cityCode);
        queryWrapper.eq("vehicle_type",vehicleType);
        queryWrapper.orderByDesc("fare_version");

        List<PriceRule> priceRules = priceRuleMapper.selectList(queryWrapper);
        if (priceRules.size() == 0) {
            return ResponseResult.fail(CommonStatusEnum.PRICE_RULE_EMPTY.getCode(),CommonStatusEnum.PRICE_RULE_EMPTY.getValue());
        }

        PriceRule priceRule = priceRules.get(0);

        log.info("根据距离，时长和计价规则，计算价格");

        double price = getPrice(distance, duration, priceRule);
        return ResponseResult.success(price);
    }

    /**
     * 根据距离和时长，计价规则，计算最终价格
     * @param distance
     * @param duration
     * @param priceRule
     * @return
     */

    //计算实际价格
    public double getPrice(Integer distance, Integer duration,PriceRule priceRule) {
        double price = 0.0;

        //起步价
        double startFare = priceRule.getStartFare();
        price = BigDecimalUtils.add(price,startFare);

        //里程费
        //总里程 m
        //总里程 km
        double distanceMile = BigDecimalUtils.divide(distance,1000);
        //起步里程
        double startMile = (double)priceRule.getStartMile();
        double distanceSubtract = BigDecimalUtils.subStract(distanceMile,startMile);
        //最终收费的里程数
        double mile = distanceSubtract < 0 ? 0 : distanceSubtract;
        //计程单价 元/km
        double unitPricePerMile = priceRule.getUnitPricePerMile();
        //里程价
        double mileFare = BigDecimalUtils.multiply(mile,unitPricePerMile);
        price = BigDecimalUtils.add(price,mileFare);

        //时长费
        //时长的分钟数
        double timeMinute = BigDecimalUtils.divide(duration,60);
        //计时单价
        Double unitPricePerMinute = priceRule.getUnitPricePerMinute();
        //时长费用
        double timeFare = BigDecimalUtils.multiply(timeMinute,unitPricePerMinute);
        price = BigDecimalUtils.add(price,timeFare);

        BigDecimal priceBigDecimal = BigDecimal.valueOf(price);
        priceBigDecimal =  priceBigDecimal.setScale(2,BigDecimal.ROUND_HALF_UP);

        return priceBigDecimal.doubleValue();
    }

//    public static void main(String[] args) {
////        PriceRule priceRule = new PriceRule();
////        priceRule.setUnitPricePerMile(1.8);
////        priceRule.setUnitPricePerMinute(0.5);
////        priceRule.setStartFare(10.0);
////        priceRule.setStartMile(3);
////        System.out.println(getPrice(6500,1800,priceRule));
////    }
}
