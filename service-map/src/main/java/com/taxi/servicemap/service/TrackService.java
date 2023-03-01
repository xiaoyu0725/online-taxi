package com.taxi.servicemap.service;

import com.taxi.internalcommon.dto.ResponseResult;
import com.taxi.internalcommon.response.TrackResponse;
import com.taxi.servicemap.remote.TrackClient;
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
