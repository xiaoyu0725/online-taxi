package com.mashibing.internalcommon.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class OrderRequest {

    /**
     * 订单ID
     */
    private Long orderId;

    /**
     * 乘客ID
     */
    private Long passengerId;

    /**
     * 乘客手机号
     */
    private String passengerPhone;

    private String address;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime departTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime orderTime;

    private String departure;

    //经度
    private String depLongitude;
    //纬度
    private String depLatitude;

    private String destination;

    private String destLongitude;

    private String destLatitude;
    //坐标加密标识 1：gcj-02;2:wgs84;3:BD-09;4.cgcs2000;0:其他
    private Integer encrypt;
    //运价类型编码
    private String fareType;
    //运价版本
    private Integer fareVersion;

    //请求设备唯一号
    private String deviceCode;

    /**
     * 司机去接乘客出发时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime toPickUpPassengerTime;

    /**
     * 去接乘客时，司机的经度
     */
    private String toPickUpPassengerLongitude;

    /**
     * 去接乘客时，司机的纬度
     */
    private String toPickUpPassengerLatitude;

    /**
     * 去接乘客时，司机的地点
     */
    private String toPickUpPassengerAddress;

    /**
     * 接到乘客，乘客上车经度
     */
    private String pickUpPassengerLongitude;

    /**
     * 接到乘客，乘客上车纬度
     */
    private String pickUpPassengerLatitude;

    /**
     * 乘客下车经度
     */
    private String passengerGetoffLongitude;

    /**
     * 乘客下车纬度
     */
    private String passengerGetoffLatitude;

    /**
     * 车型
     */
    private String vehicleType;

}
