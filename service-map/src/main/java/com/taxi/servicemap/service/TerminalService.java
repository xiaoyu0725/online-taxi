package com.taxi.servicemap.service;

import com.taxi.internalcommon.dto.ResponseResult;
import com.taxi.internalcommon.response.TerminalResponse;
import com.taxi.internalcommon.response.TrsearchResponse;
import com.taxi.servicemap.remote.TerminalClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TerminalService {

    @Autowired
    TerminalClient terminalClient;

    public ResponseResult<TerminalResponse> add(String name,String desc){
        return terminalClient.add(name,desc);
    }

    public ResponseResult<List<TerminalResponse>> aroundSearch(String center, Integer radius){
        return terminalClient.aroundSearch(center,radius);
    }

    public ResponseResult<TrsearchResponse> trsearch(String tid, Long starttime, Long endtime){
        return terminalClient.trsearch(tid,starttime,endtime);
    }
}
