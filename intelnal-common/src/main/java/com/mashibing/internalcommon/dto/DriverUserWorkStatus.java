package com.mashibing.internalcommon.dto;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author 晁鹏飞
 * @since 2023-02-06
 */
@Data
public class DriverUserWorkStatus implements Serializable {

    private Long id;

    private Long driverId;

    private Integer workStatus;

    private LocalDateTime gmtCreate;

    private LocalDateTime gmtModified;

}
