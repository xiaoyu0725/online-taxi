package com.taxi.internalcommon.response;

import lombok.Data;

@Data
public class TerminalResponse {

    public String tid;

    private Long carId;

    private String longitude;

    private String latitude;
}
