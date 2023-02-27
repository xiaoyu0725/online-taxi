package com.mashibing.internalcommon.request;

import lombok.Data;

@Data
public class PriceRulesNewRequest {

    private String fareType;
    private Integer fareVersion;
}
