package com.taxi.internalcommon.request;

import lombok.Data;

@Data
public class VerificationCodeDTO {
    private String passengerPhone;

    public String verificationCode;

    private String driverPhone;

}
