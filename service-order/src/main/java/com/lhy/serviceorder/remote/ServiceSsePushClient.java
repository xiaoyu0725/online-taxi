package com.lhy.serviceorder.remote;

import com.lhy.internalcommon.request.PushRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient("service-sse-push")
public interface ServiceSsePushClient {

    @PostMapping(value = "/push")
    public String push(@RequestBody PushRequest pushRequest);
}
