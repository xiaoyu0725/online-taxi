package com.mashibing.servicemap.service;

import com.mashibing.internalcommon.constant.AmapConfigConstants;
import com.mashibing.internalcommon.constant.CommonStatusEnum;
import com.mashibing.internalcommon.dto.DicDistrict;
import com.mashibing.internalcommon.dto.ResponseResult;
import com.mashibing.servicemap.mapper.DicDistrictMapper;
import com.mashibing.servicemap.remote.MapDicDistrictClient;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DicDistrictService {

    @Autowired
    private DicDistrictMapper dicDistrictMapper;

    @Autowired
    private MapDicDistrictClient mapDicDistrictClient;


    public ResponseResult initDicDistrict(String keywords){

        //请求地图
        String dicDistrictResult = mapDicDistrictClient.dicDistrict(keywords);
        System.out.println(dicDistrictResult);
        //解析结果
        JSONObject dicDistrictJsonObject = JSONObject.fromObject(dicDistrictResult);
        int status = dicDistrictJsonObject.getInt(AmapConfigConstants.STATUS);
        if (status != 1) {
            return ResponseResult.fail(CommonStatusEnum.MAP_DISTRICT_ERROR.getCode(),CommonStatusEnum.MAP_DISTRICT_ERROR.getValue());
        }
        JSONArray countryJsonArray = dicDistrictJsonObject.getJSONArray(AmapConfigConstants.DISTRICTS);
        for (int country = 0;country < countryJsonArray.size();country++) {
            JSONObject countryJsonObject = countryJsonArray.getJSONObject(country);
            String countryAddressCode = countryJsonObject.getString(AmapConfigConstants.ADCODE);
            String countryAddressName = countryJsonObject.getString(AmapConfigConstants.NAME);
            String countryParentAddressCode = "0";
            String countryLevel = countryJsonObject.getString(AmapConfigConstants.LEVEL);

            insertDicDistrict(countryAddressCode,countryAddressName,countryLevel,countryParentAddressCode);

            JSONArray provinceJsonArray = countryJsonObject.getJSONArray(AmapConfigConstants.DISTRICTS);
            for (int p = 0;p < provinceJsonArray.size();p++) {
                JSONObject provinceJsonObject = provinceJsonArray.getJSONObject(p);
                String provinceAddressCode = provinceJsonObject.getString(AmapConfigConstants.ADCODE);
                String provinceAddressName = provinceJsonObject.getString(AmapConfigConstants.NAME);
                String provinceParentAddressCode = countryAddressCode;
                String provinceLevel = provinceJsonObject.getString(AmapConfigConstants.LEVEL);

                insertDicDistrict(provinceAddressCode,provinceAddressName,provinceLevel,provinceParentAddressCode);

                JSONArray cityArray = provinceJsonObject.getJSONArray(AmapConfigConstants.DISTRICTS);
                for (int city = 0;city < cityArray.size();city++) {
                    JSONObject cityJsonObject = cityArray.getJSONObject(city);
                    String cityAddressCode = cityJsonObject.getString(AmapConfigConstants.ADCODE);
                    String cityAddressName = cityJsonObject.getString(AmapConfigConstants.NAME);
                    String cityParentAddressCode = provinceAddressCode;
                    String cityLevel = cityJsonObject.getString(AmapConfigConstants.LEVEL);

                    insertDicDistrict(cityAddressCode,cityAddressName,cityLevel,cityParentAddressCode);

                    JSONArray districtArray = cityJsonObject.getJSONArray(AmapConfigConstants.DISTRICTS);
                    for (int d = 0;d < districtArray.size();d++) {
                        JSONObject districtJsonObject = districtArray.getJSONObject(d);
                        String districtAddressCode = districtJsonObject.getString(AmapConfigConstants.ADCODE);
                        String districtAddressName = districtJsonObject.getString(AmapConfigConstants.NAME);
                        String districtParentAddressCode = cityAddressCode;
                        String districtLevel = districtJsonObject.getString(AmapConfigConstants.LEVEL);

                        if (districtLevel.equals(AmapConfigConstants.STREET)) {
                            continue;
                        }

                        insertDicDistrict(districtAddressCode,districtAddressName,districtLevel,districtParentAddressCode);

                    }
                }
            }
        }


        return ResponseResult.success("");
    }

    public void insertDicDistrict(String addressCode, String addressName, String level,String parentAddressCode){
        //数据库对象
        DicDistrict district = new DicDistrict();
        district.setAddressCode(addressCode);
        district.setAddressName(addressName);
        int levelInt = generateLevel(level);
        district.setLevel(levelInt);

        district.setParentAddressCode(parentAddressCode);
        //插入到数据库
        dicDistrictMapper.insert(district);
    }

    public int generateLevel(String level){
        int levelInt = 0;
        if (level.trim().equals("country")) {
            levelInt = 0;
        }else if (level.trim().equals("province")) {
            levelInt = 1;
        }else if (level.trim().equals("city")) {
            levelInt = 2;
        }else if (level.trim().equals("district")) {
            levelInt = 3;
        }
        return levelInt;
    }



}
