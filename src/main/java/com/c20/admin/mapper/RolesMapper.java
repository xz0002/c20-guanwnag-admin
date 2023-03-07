package com.c20.admin.mapper;

import com.c20.admin.entity.Roles;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
* @author xin
* @description 针对表【roles】的数据库操作Mapper
* @createDate 2023-03-07 10:47:18
* @Entity com.c20.admin.entity.Roles
*/
public interface RolesMapper extends BaseMapper<Roles> {

    List<Long> findRolesByUserId(Long userId);

}




