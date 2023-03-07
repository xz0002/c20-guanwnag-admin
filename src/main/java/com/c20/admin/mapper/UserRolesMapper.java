package com.c20.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.c20.admin.entity.UserRoles;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author xin
 * @description 针对表【user_roles】的数据库操作Mapper
 * @createDate 2023-03-07 11:35:37
 * @Entity com.c20.admin.entity.UserRoles
 */
@Repository
public interface UserRolesMapper extends BaseMapper<UserRoles> {
    List<Long> selectUserIdsByRoleId(Long roleId);
}




