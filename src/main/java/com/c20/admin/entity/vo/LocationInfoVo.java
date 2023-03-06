package com.c20.admin.entity.vo;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author 辛老板
 * @version 1.0.0
 * @date 2023-03-06 13:24
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

    /**
     * 地址名称
     */
    private String name;

    /**
     * 详细地址
     */
    private String address;
}
