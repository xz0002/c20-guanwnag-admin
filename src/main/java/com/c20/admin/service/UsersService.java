package com.c20.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.c20.admin.entity.Users;

import java.util.List;

/**
 * @author xin
 * @description 针对表【users】的数据库操作Service
 * @createDate 2023-03-07 10:47:18
 */
public interface UsersService extends IService<Users> {

    List<Users> findUsersByRoleId(Long roleId);
}
