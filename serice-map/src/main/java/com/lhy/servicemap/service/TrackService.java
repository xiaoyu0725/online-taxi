package com.lhy.servicemap.service;

import com.lhy.internalcommon.dto.ResponseResult;
import com.lhy.internalcommon.responese.TrackResponse;
import com.lhy.servicemap.remote.TrackClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrackService {

    @Autowired
    TrackClient trackClient;

    public ResponseResult<TrackResponse> add(String tid){

        return trackClient.add(tid);
    }
}
