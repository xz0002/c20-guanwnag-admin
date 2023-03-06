package com.c20.admin.entity.vo;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author 辛老板
 * @version 1.0.0
 * @date 2023-03-06 11:10
 */
@Data
public class LocationInfoVo implements Serializable {

    /**
     * 经度
     */
    private BigDecimal latitude;

    /**
     * 纬度
     */
    private BigDecimal longitude;

}
