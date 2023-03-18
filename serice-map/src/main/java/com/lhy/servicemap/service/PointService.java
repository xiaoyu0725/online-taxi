package com.lhy.servicemap.service;

import com.lhy.internalcommon.dto.ResponseResult;
import com.lhy.internalcommon.request.PointRequest;
import com.lhy.servicemap.remote.PointClient;
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
