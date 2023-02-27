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
 * @since 2023-02-05
 */
@Data
public class DriverCarBindingRelationship implements Serializable {

    private Long id;

    private Long driverId;

    private Long carId;

    private Integer bindState;

    private LocalDateTime bindingTime;

    private LocalDateTime unBindingTime;


}
