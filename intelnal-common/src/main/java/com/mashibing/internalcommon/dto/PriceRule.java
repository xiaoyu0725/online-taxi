package com.mashibing.internalcommon.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author 晁鹏飞
 * @since 2023-02-08
 */
@Data
public class PriceRule implements Serializable {

    private static final long serialVersionUID = 1L;

    private String cityCode;

    private String vehicleType;

    private Double startFare;

    private Integer startMile;

    private Double unitPricePerMile;

    private Double unitPricePerMinute;

    private Integer fareVersion;

    private String fareType;


}
