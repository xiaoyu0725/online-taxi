package com.lhy.internalcommon.request;

import lombok.Data;

@Data
public class PushRequest {

    private int userId;
    private String identity;
    private String content;

}
