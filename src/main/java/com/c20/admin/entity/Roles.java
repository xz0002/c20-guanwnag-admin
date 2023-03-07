package com.c20.admin.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @TableName roles
 */
@TableName(value = "roles")
@Data
public class Roles extends BaseRntity implements Serializable {
    /**
     * 角色ID
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 角色名
     */
    private String name;

    /**
     * 角色描述
     */
    private String description;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    // 角色与用户属于一对多关系，所以这里需要使用集合，数据库中不需要此字段
    @TableField(exist = false)
    private List<Users> usersList;

    // 角色与权限属于多对多关系
    @TableField(exist = false)
    private List<Permissions> permissionsList;
}