package com.c20.admin.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @TableName permissions
 */
@TableName(value = "permissions")
@Data
public class Permissions extends BaseRntity implements Serializable {
    /**
     * 权限ID
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 权限名
     */
    private String name;

    /**
     * 权限描述
     */
    private String description;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

}