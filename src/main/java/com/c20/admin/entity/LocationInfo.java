package com.c20.admin.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @TableName location_info
 */
@TableName(value = "location_info")
@Data
public class LocationInfo implements Serializable {
    /**
     * 主键id
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

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

    /**
     * 描述信息
     */
    private String description;

    /**
     * 图片链接
     */
    private String imageUrl;

    /**
     * 所属城市
     */
    private String city;

    /**
     * 所属国家
     */
    private String country;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}