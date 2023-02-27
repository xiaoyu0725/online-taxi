package com.mashibing.internalcommon.response;

import lombok.Data;

@Data
public class OrderDriverResponse {

    private Long driverId;

    private String driverPhone;

    private Long carId;

    private String licenseId;

    private String vehicleNo;

    /**
     * 车型
     */
    private String vehicleType;
}
