package com.c20.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.c20.admin.entity.Permissions;

import java.util.List;

/**
 * @author xin
 * @description 针对表【permissions】的数据库操作Service
 * @createDate 2023-03-07 10:47:18
 */
public interface PermissionsService extends IService<Permissions> {

    List<Permissions> findPermissionByRoleId(Long rid);
}
