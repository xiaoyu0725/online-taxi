package com.taxi.servicemap.controller;

import com.taxi.internalcommon.dto.ResponseResult;
import com.taxi.internalcommon.response.TrackResponse;
import com.taxi.servicemap.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/track")
public class TrackController {

    @Autowired
    TrackService trackService;

    @PostMapping("/add")
    public ResponseResult<TrackResponse> add(String tid){
        return trackService.add(tid);
    }
}
