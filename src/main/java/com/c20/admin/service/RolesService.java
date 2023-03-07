package com.c20.admin.service;

import com.c20.admin.entity.Roles;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author xin
 * @description 针对表【roles】的数据库操作Service
 * @createDate 2023-03-07 10:47:18
 */
public interface RolesService extends IService<Roles> {

    List<Roles> findRolesByUserId(Long userId);
}
