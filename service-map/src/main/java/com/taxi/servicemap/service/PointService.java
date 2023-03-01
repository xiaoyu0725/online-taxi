package com.taxi.servicemap.service;

import com.taxi.internalcommon.dto.ResponseResult;
import com.taxi.internalcommon.request.PointRequest;
import com.taxi.servicemap.remote.PointClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PointService {

    @Autowired
    PointClient pointClient;

    public ResponseResult upload(PointRequest pointRequest){

        return pointClient.upload(pointRequest);
    }
}