package com.lhy.internalcommon.responese;

import lombok.Data;

@Data
public class OrderDriverResponse {

    private int driverId;

    private String driverPhone;

    private int carId;

    /**
     * 机动车驾驶证号
     */
    private String licenseId;

    /**
     * 车辆号牌
     */
    private String vehicleNo;

    /**
     * 车辆类型
     */
    private String vehicleType;
}
